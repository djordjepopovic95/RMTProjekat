package projekatServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.LinkedList;

public class ServerNit extends Thread {

	BufferedReader ulazniTokOdKlijenta = null;
	PrintStream izlazniTokKaKlijentu = null;
	Socket soketZaKomunikaciju = null;
	ServerNit[] igraci;

	boolean kraj = false;
	String color;
	String linija;
	boolean naPotezu = false;

	public ServerNit(Socket soket, ServerNit[] igraci) {
		soketZaKomunikaciju = soket;
		this.igraci = igraci;
	}

	public ServerNit() {
	}

	@Override
	public void run() {
		try {
			ulazniTokOdKlijenta = new BufferedReader(new InputStreamReader(soketZaKomunikaciju.getInputStream()));
			izlazniTokKaKlijentu = new PrintStream(soketZaKomunikaciju.getOutputStream());

			if (igraci[0] != null && igraci[0].izlazniTokKaKlijentu != null) { //ovo sluzi da prvom koji se konektvoao kaze da je na potezu
				igraci[0].izlazniTokKaKlijentu.println("na potezu");
				igraci[0].naPotezu = true;
			}
			while (true) {

				if (kraj) {
					break;
				}

				linija = ulazniTokOdKlijenta.readLine();
				if (linija.equals("protivnik je pobedio")) {
					kraj = true;
					for (ServerNit i : igraci) {

						if (i != this && naPotezu == true) {
							i.izlazniTokKaKlijentu.println("pobedio si");
							i.kraj = true;
							break;
						}
					}
					break;
				}

				if (linija.equals("pobedio sam")) {
					kraj = true;
					break;
				}

				if (naPotezu) {

					for (ServerNit i : igraci) {

						if (i != this && naPotezu == true) {
							i.izlazniTokKaKlijentu.println(linija);
							i.naPotezu = true;
						}
					}
					naPotezu = false;
				}
			}

			soketZaKomunikaciju.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (ServerNit i : igraci) {
			if (i == this) {
				i = null;
			}
		}
	}

}

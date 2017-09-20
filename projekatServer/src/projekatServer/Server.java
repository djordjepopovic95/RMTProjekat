package projekatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	static ServerNit[] igraci = new ServerNit[2];
	static int brIgraca = 0;

	public static void main(String[] args) {
		int port = 6776;
		Socket soket = null;

		try {
			ServerSocket serverSoket = new ServerSocket(port); //!!

			while (true) {
				soket = serverSoket.accept(); //!!
				igraci[brIgraca] = new ServerNit(soket, igraci);
				brIgraca++;
				if (brIgraca == 2) {
					brIgraca = 0;
					ServerNit[] slanje = new ServerNit[2];
					slanje[0] = new ServerNit();
					slanje[0].soketZaKomunikaciju = igraci[0].soketZaKomunikaciju;
					slanje[0].igraci = slanje;
					slanje[1] = new ServerNit();
					slanje[1].soketZaKomunikaciju = igraci[1].soketZaKomunikaciju;
					slanje[1].igraci = slanje;
					
 					new Soba(slanje).main(args);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

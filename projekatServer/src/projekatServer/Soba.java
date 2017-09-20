package projekatServer;

import projekatServer.ServerNit;

public class Soba {
	
    static	ServerNit[] igraci;

	public Soba(ServerNit[] igraci) {
		this.igraci = igraci;
	}
	
	public static void main(String[] args) {
		igraci[0].start();
		System.out.println("Pokrenut prvi igrac");
		igraci[1].start();
		System.out.println("Pokrenut drugi igrac");
	}
}

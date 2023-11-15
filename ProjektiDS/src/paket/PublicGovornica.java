package paket;

import java.util.LinkedList;
import java.util.Queue;

class PublicGovornica {
    private static final int NAJVISE_OSOBA = 20;
    private static final int BROJ_GOVORNICA= 4;

    private Queue<Osoba> red;
    private Govornica[] govornica;

    public PublicGovornica() {
        this.red = new LinkedList<>();
        this.govornica = new Govornica[BROJ_GOVORNICA];
        for (int i = 0; i < BROJ_GOVORNICA; i++) {
            this.govornica[i] = new Govornica();
        }
    }

    public synchronized void dodajURed(Osoba osoba) {
        if (red.size() < NAJVISE_OSOBA) {
        	red.add(osoba);
            notifyAll();
        } else {
            System.out.println("Red je pun " + osoba + "ne moze da udje");
        }
    }

    public synchronized Osoba uzmiSledecuOsobu() throws InterruptedException {
        while (red.isEmpty()) {
            wait();
        }
        return red.poll();
    }

    public Govornica[] uzmiGovornicu() {
        return govornica;
    }
}

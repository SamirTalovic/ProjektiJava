package paket;

import paket.Osoba;
import paket.Govornica;
import paket.PublicGovornica;

class Osoba extends Thread {
    private static int brojac = 1;
    private int id;

    public Osoba() {
        this.id = brojac++;
    }

    @Override
    public void run() {
        try {
            PublicGovornica publicgovornica = new PublicGovornica();
            publicgovornica.dodajURed(this);
            Osoba sledecaOsoba = publicgovornica.uzmiSledecuOsobu();
            Govornica[] govornice = publicgovornica.uzmiGovornicu();
            for (Govornica govornica : govornice) {
                if (govornica != null) {
                    govornica.koristiGovornicu(sledecaOsoba);
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Osoba " + id;
    }
}

package paket;

import paket.Osoba;

public class SimulacijaGovornice {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Osoba().start();
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

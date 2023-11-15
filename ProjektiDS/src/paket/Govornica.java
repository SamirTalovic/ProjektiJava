package paket;

import java.util.Random;

class Govornica {
    private static final int NAJMANJE_VREME = 5000; 
    private static final int NAJVECE_VREME = 10000; 

    public void koristiGovornicu(Osoba osoba) throws InterruptedException {
        System.out.println(osoba + " koristi govornicu");
        Thread.sleep(new Random().nextInt(NAJVECE_VREME - NAJMANJE_VREME) + NAJMANJE_VREME);
        System.out.println(osoba + " je zavrsio sa koriscenjem govornice");
    }
}

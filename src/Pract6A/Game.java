package Pract6A;

import java.time.LocalDate;

public class Game {

    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr) {
        naam = nm;
        releaseJaar = rJ;
        nieuwprijs = nwpr;
    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        return nieuwprijs * (Math.pow(0.70, LocalDate.now().getYear() - releaseJaar));
    }

    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false;

        if (andereObject instanceof Game) {
            Game andereGame = (Game) andereObject;

            if (this.naam.equals(andereGame.naam) && this.releaseJaar == andereGame.releaseJaar) {
                gelijkeObjecten = true;
            }
        }

        return gelijkeObjecten;
    }

    public String toString() {
        return naam + ", uitgegeven in " + releaseJaar + "; nieuwprijs: €" + nieuwprijs + " nu voor: €" + huidigeWaarde();
    }
}

package Pract6A;

import java.util.ArrayList;

public class Persoon {

    private String naam;
    private double budget;
    private ArrayList<Game> games;

    public Persoon(String nm, double bud) {
        naam = nm;
        budget = bud;
        games = new ArrayList<Game>();
    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game g) {
        if (g.huidigeWaarde() < budget && !games.contains(g)) {
            budget -= g.huidigeWaarde();

            games.add(g);
            return true;
        }
        return false;
    }

    public boolean verkoop(Game g, Persoon koper) {
        if (g.huidigeWaarde() < koper.getBudget() && games.contains(g) && !koper.games.contains(g)) {
            games.remove(g);
            koper.games.add(g);
            budget += g.huidigeWaarde();
            koper.budget -= g.huidigeWaarde();
            return true;
        }
        return false;
    }

    public String toString() {
        String s = naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:";

        for(Game g : games) {
            s += ("\n" + g.toString());
        }

        return s;
    }
}

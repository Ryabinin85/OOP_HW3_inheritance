package animals;

import animals.amphibians.Amphibians;
import animals.birds.Flightless;
import animals.birds.Flying;
import animals.mammals.Herbivorous;
import animals.mammals.Predators;

public class Main {
    public static void main(String[] args) {
        Herbivorous gazelle = new Herbivorous("gazelle", 1, "savannah", 45, "leaves");
        Herbivorous giraffe = new Herbivorous("giraffe", 5, "savannah", 35, "thorns");
        Herbivorous horse = new Herbivorous("horse", 7, "plain", 55, "grass");
        Predators hyena = new Predators("hyena", 2, "savannah", 40, "carrion");
        Predators tiger = new Predators("tiger", 5, "savannah", 50, "meat");
        Predators bear = new Predators("bear", 6, "savannah", 40, "omnivorous");
        Amphibians grassSnake = new Amphibians("grassSnake", 1, "forest");
        Amphibians frog = new Amphibians("frog", 1, "swamp");
        Flightless peacock = new Flightless("peacock", 1 , "tropical forest", "walking");
        Flightless penguin = new Flightless("penguin", 7 , "antarctic", "walking");
        Flightless dodoBird = new Flightless("dodoBird", 1 , "islands of Mauritius", "walking");
        Flying seagull = new Flying("seagull", 1 , "marine water areas", "flying");
        Flying albatross = new Flying("albatross", 8 , "antarctic", "flying");
        Flying falcon = new Flying("falcon", 3 , "tropics", "flying");

        System.out.println(gazelle);
        System.out.println(giraffe);
        System.out.println(horse);
        System.out.println(hyena);
        System.out.println(tiger);
        System.out.println(bear);
        System.out.println(grassSnake);
        System.out.println(frog);
        System.out.println(peacock);
        System.out.println(penguin);
        System.out.println(dodoBird);
        System.out.println(seagull);
        System.out.println(albatross);
        System.out.println(falcon);

        System.out.println(gazelle.getName() + " - " + gazelle.getClass());
        System.out.println(giraffe.getName() + " - " + giraffe.getClass());
        System.out.println(horse.getName() + " - " + horse.getClass());
        System.out.println(hyena.getName() + " - " + hyena.getClass());
        System.out.println(tiger.getName() + " - " + tiger.getClass());
        System.out.println(bear.getName() + " - " + bear.getClass());
        System.out.println(grassSnake.getName() + " - " + grassSnake.getClass());
        System.out.println(frog.getName() + " - " + frog.getClass());
        System.out.println(peacock.getName() + " - " + peacock.getClass());
        System.out.println(penguin.getName() + " - " + penguin.getClass());
        System.out.println(dodoBird.getName() + " - " + dodoBird.getClass());
        System.out.println(seagull.getName() + " - " + seagull.getClass());
        System.out.println(albatross.getName() + " - " + albatross.getClass());
        System.out.println(falcon.getName() + " - " + falcon.getClass());
    }
}

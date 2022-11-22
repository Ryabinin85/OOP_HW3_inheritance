package animals.mammals;

import animals.Animals;
import animals.Validator;

public abstract class Mammals extends Animals {
    private final String habitat;
    private final int movementSpeed;

    public Mammals(String name, int age, String habitat, int movementSpeed) {
        super(name, age);
        this.habitat = Validator.validateString(habitat);
        this.movementSpeed = Validator.validateInteger(movementSpeed);
    }

    public void walk() {
        System.out.println("I'm walk");
    }

    @Override
    public void eat() {
        System.out.println("I eat");
    }

    @Override
    public void sleep() {
        System.out.println("I sleep");
    }

    @Override
    public void go() {
        System.out.println("I can move with speed " + movementSpeed  + "km/h");
    }

    public String getHabitat() {
        return habitat;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }
}

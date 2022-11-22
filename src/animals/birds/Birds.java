package animals.birds;

import animals.Animals;
import animals.Validator;

public abstract class Birds extends Animals {
    private final String habitat;

    public Birds(String name, int age, String habitat) {
        super(name, age);
        this.habitat = Validator.validateString(habitat);
    }

    public void hunt() {
        System.out.println("I'm hunting");
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
        System.out.println("I walk");
    }

    public String getHabitat() {
        return habitat;
    }

}

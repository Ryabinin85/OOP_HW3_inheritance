package animals.amphibians;

import animals.Animals;
import animals.Validator;
import animals.birds.Flying;

import java.util.Objects;

public class Amphibians extends Animals {
    private String habitat;

    public Amphibians(String name, int age, String habitat) {
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
        System.out.println("I move on water and land");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amphibians amphibians = (Amphibians) o;
        return Objects.equals(getName(), amphibians.getName()) && Objects.equals(habitat, amphibians.habitat) &&
                Objects.equals(getAge(), amphibians.getAge());
    }
    @Override
    public int hashCode() {
        return Objects.hash(habitat, getName(), getAge());
    }
    @Override
    public String toString() {
        return String.format("Amphibians: %s, age: %d, habitat: %s\n\n",
                getName(), getAge(), habitat);
    }
}

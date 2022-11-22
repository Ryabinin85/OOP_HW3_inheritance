package animals.birds;

import animals.Validator;

import java.util.Objects;

public class Flying extends Birds {
    private final String typeOfMovement;

    public Flying(String name, int age, String habitat, String typeOfMovement) {
        super(name, age, habitat);
        this.typeOfMovement = Validator.validateString(typeOfMovement);
    }
    public void fly() {
        System.out.println("I can fly");
    }

    public String getTypeOfMovement() {
        return typeOfMovement;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flying flying = (Flying) o;
        return Objects.equals(typeOfMovement, flying.typeOfMovement) && Objects.equals(getName(), flying.getName()) &&
                Objects.equals(getHabitat(), flying.getHabitat()) && Objects.equals(getAge(), flying.getAge());
    }
    @Override
    public int hashCode() {
        return Objects.hash(typeOfMovement, getName(), getAge(), getHabitat());
    }
    @Override
    public String toString() {
        return String.format("Bird: %s, age: %d, habitat: %s, type of movement: %s\n\n",
                getName(), getAge(), getHabitat(), typeOfMovement);
    }
}

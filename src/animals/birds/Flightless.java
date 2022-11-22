package animals.birds;

import animals.Validator;

import java.util.Objects;

public class Flightless extends Birds {
    private final String typeOfMovement;

    public Flightless(String name, int age, String habitat, String typeOfMovement) {
        super(name, age, habitat);
        this.typeOfMovement = Validator.validateString(typeOfMovement);
    }
    public void walk() {
        System.out.println("I can't fly, i walk land");
    }

    public String getTypeOfMovement() {
        return typeOfMovement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flightless flightless = (Flightless) o;
        return Objects.equals(typeOfMovement, flightless.typeOfMovement) && Objects.equals(getName(), flightless.getName()) &&
                Objects.equals(getHabitat(), flightless.getHabitat()) && Objects.equals(getAge(), flightless.getAge());
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

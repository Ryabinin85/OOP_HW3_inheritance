package animals.mammals;

import animals.Validator;

import java.util.Objects;

public class Predators extends Mammals {
    private String typeOfFood;

    public Predators(String name, int age, String habitat, int movementSpeed, String typeOfFood) {
        super(name, age, habitat, movementSpeed);
        this.typeOfFood = Validator.validateString(typeOfFood);
    }
    public void hunt() {
        System.out.println("I'm hunting");
    }
    public void eat() {
        System.out.println("I'm eat" + typeOfFood);
    }
    public void sleep() {
        System.out.println("I sleep when I'm full");
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = Validator.validateString(typeOfFood);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Predators predators = (Predators) o;
        return Objects.equals(typeOfFood, predators.typeOfFood) && Objects.equals(getName(), predators.getName()) &&
                Objects.equals(getHabitat(), predators.getHabitat()) && Objects.equals(getAge(), predators.getAge()) &&
                Objects.equals(getMovementSpeed(), predators.getMovementSpeed());
    }
    @Override
    public int hashCode() {
        return Objects.hash(typeOfFood, getName(), getAge(), getHabitat(), getMovementSpeed());
    }
    @Override
    public String toString() {
        return String.format("Mammal: %s, age: %d, habitat: %s, movement speed: %d, type of food: %s\n\n",
                getName(), getAge(), getHabitat(), getMovementSpeed(), typeOfFood);
    }
}

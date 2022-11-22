package animals.mammals;

import animals.Validator;

import java.util.Objects;

public class Herbivorous extends Mammals {
    private String typeOfFood;

    public Herbivorous(String name, int age, String habitat, int movementSpeed, String typeOfFood) {
        super(name, age, habitat, movementSpeed);
        this.typeOfFood = Validator.validateString(typeOfFood);
    }
    public void graze() {
        System.out.println("I'm graze");
    }
    public void eat() {
        System.out.println("I'm eat" + typeOfFood);
    }
    public void sleep() {
        System.out.println("I'm sleeping at night");
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
        Herbivorous herbivorous = (Herbivorous) o;
        return Objects.equals(typeOfFood, herbivorous.typeOfFood) && Objects.equals(getName(), herbivorous.getName()) &&
                Objects.equals(getHabitat(), herbivorous.getHabitat()) && Objects.equals(getAge(), herbivorous.getAge()) &&
                Objects.equals(getMovementSpeed(), herbivorous.getMovementSpeed());
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

package animals;

public abstract class Animals {
    private final String name;
    private final int age;

    public Animals(String name, int age) {
        this.name = Validator.validateString(name);
        this.age = Validator.validateInteger(age);
    }
    public abstract void eat();
    public abstract void sleep();
    public abstract void go();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
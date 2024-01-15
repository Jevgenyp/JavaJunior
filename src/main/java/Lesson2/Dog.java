package Lesson2;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, Integer age, String breed) {
        setName(name);
        setAge(age);
        this.breed = breed;

    }

    public void makeSound(){
        System.out.println(getName() + " says: Woof!");
    }
}


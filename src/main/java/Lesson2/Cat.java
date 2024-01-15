package Lesson2;

public class Cat extends Animal {
    private String color;
    public Cat(String name, Integer age, String color) {

        setName(name);
        setAge(age);
        this.color = color;
    }


    public void makeSound(){
        System.out.println(getName() + " says: Meow! ");
    }
}

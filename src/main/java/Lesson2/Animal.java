package Lesson2;

//Создайте абстрактный класс "Animal" с полями "name" и "age".
//Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
//Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
//Выведите на экран информацию о каждом объекте.
//Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.

public abstract class Animal {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {

    }

}

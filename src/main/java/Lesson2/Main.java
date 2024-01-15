package Lesson2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Dog("Buddy", 5, "Border Collie"),
                new Cat("Dori", 3, "Black")

        };
        for (Animal animal : animals) {
            System.out.println("Name: " + animal.getName() + ", Age: " + animal.getAge());

            try {
                Method method = animal.getClass().getMethod("makeSound");
                method.invoke(animal);


            } catch (NoSuchMethodException e){
                System.out.println(animal.getName() + "has no makeSound method");
            }
            catch (Exception e){
                e.printStackTrace();
            }


            try {
                Field breedField = animal.getClass().getDeclaredField("breed");
                breedField.setAccessible(true);
                Object breedValue = breedField.get(animal);
                System.out.println("Breed: " + breedValue);
            } catch (NoSuchFieldException e) {

            } catch (Exception e) {
                e.printStackTrace();
            }



            try {
                Field colorField = animal.getClass().getDeclaredField("color");
                colorField.setAccessible(true);
                Object colorValue = colorField.get(animal);
                System.out.println("Color: " + colorValue);
            } catch (NoSuchFieldException e) {

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}



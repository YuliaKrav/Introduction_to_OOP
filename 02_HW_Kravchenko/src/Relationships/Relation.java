package Relationships;

import Animals.Animal;
import People.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Relation {
    private HashMap<Person, List<Animal>> peopleAnimalsRelations;

    public Relation() {
        peopleAnimalsRelations = new HashMap<>();
    }

    public void addRelation(Person person, Animal animal) {
        List<Animal> newAnimalList = new ArrayList<>();
        newAnimalList.add(animal);
        if (peopleAnimalsRelations.containsKey(person)) {
            newAnimalList.addAll(peopleAnimalsRelations.get(person));
        }
        peopleAnimalsRelations.put(person, newAnimalList);
    }

    public void addRelation(Person person, List<Animal> animalList) {
        for (Animal animal : animalList) {
            addRelation(person, animal);
        }
    }

    public void printAllAnimals(Person person) {
        System.out.println(person + " has " + peopleAnimalsRelations.get(person).size() + " animal(s):");
        int count = 1;
        for (Animal animal : peopleAnimalsRelations.get(person)) {
            System.out.println("Animal " + count + ":");
            animal.getFullDescription();
            System.out.println();
            count++;
        }
    }

    private String getAnimalType(Class<?> classType) {
        String animalType = classType.getTypeName().toLowerCase();
        return animalType.contains(".") ?
                animalType.substring(animalType.lastIndexOf(".") + 1) :
                animalType;
    }

    public void makeASoundСommand(Person person, Class<?> classType) {
        int counter = 0;
        System.out.println(person + " gives his(her) " + getAnimalType(classType) + "(s) a command \"Voice\"");

        if (peopleAnimalsRelations.containsKey(person)) {
            for (Animal animal : peopleAnimalsRelations.get(person)) {
                if (classType.isInstance(animal)) {
                    animal.performVoice();
                }
            }
        }
        if (counter == 0) {
            System.out.println("but the person doesn't have a " + getAnimalType(classType) + ".");
        }
    }

    public void makeASoundСommand(Person person, List<Class<?>> classTypeList) {
        for (var classType : classTypeList) {
            makeASoundСommand(person, classType);
            System.out.println();
        }
    }

    public void makeAComeСommand(Person person, Class<?> classType, int times) {
        int counter = 0;

        System.out.println(person + " gives his(her) " + getAnimalType(classType) + "(s) a command \"Come\" " + times + " times.");
        if (peopleAnimalsRelations.containsKey(person)) {
            for (Animal animal : peopleAnimalsRelations.get(person)) {
                if (classType.isInstance(animal)) {
                    animal.performMove(times);
                    counter++;
                }
            }
        }
        if (counter == 0) {
            System.out.println("but the person doesn't have a " + getAnimalType(classType) + ".");
        }
    }

    public void makeAComeСommand(Person person, Class<?> classType) {
        makeAComeСommand(person, classType, 1);
    }

    public void makeAComeСommand(Person person, List<Class<?>> classTypeList) {
        for (var classType : classTypeList) {
            makeAComeСommand(person, classType);
            System.out.println();
        }
    }

    public void makeAComeСommand(Person person, Animal animalType, int times) {
        int counter = 0;

        System.out.println(person + " gives his(her) " + getAnimalType(animalType.getClass()) + " " + animalType.getNickname() + " a command \"Come\" " + times + " times.");
        if (peopleAnimalsRelations.containsKey(person)) {
            for (Animal animal : peopleAnimalsRelations.get(person)) {
                if (animal.equals(animalType)) {
                    animal.performMove(times);
                    counter++;
                }
            }
        }
        if (counter == 0) {
            System.out.println("but the person doesn't have a " + getAnimalType(animalType.getClass()) + ".");
        }
    }

    public void makeAComeСommand(Person person, Animal animalType) {
        makeAComeСommand(person, animalType, 1);
    }
}

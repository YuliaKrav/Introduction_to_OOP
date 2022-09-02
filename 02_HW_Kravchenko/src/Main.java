import Animals.*;
import People.Person;
import Relationships.Relation;

import java.util.List;

public class Main {

//    Используйте предыдущие задачи из прошлого домашнего задания. Необходимо гарантированно продумать иерархию компонент
//    и взаимодействия их между собой.
//    Обеспечить переход от использования явных классов в сторону использования абстрактных типов. Т е работаем не с:
//    конкретным экземпляром генеалогического древа, а с интерфейсом “ генеалогическое древо”
//    конкретным экземпляром котика, а с интерфейсом “котик”, лучше уйти от взаимодействия с конкретными питомцами и
//    повысить уровень абстракции до взаимодействия с котиком, собачкой или хомяком т е с интерфейсом “животное”
//
//    Также в рамках домашней работы, необходимо доработать взаимодействие человека с животными:
//            1. Добавить побольше животных
//2. Добавить само взаимодействие - подозвать любое животное, дать команду животному на действие, подозвать группу животных
// одного типа, а может и нескольких типов.
//3. Использовать в работе принципы асбтракции и инкапсуляции.

    public static void main(String[] args) {
        Cat catIvan = new Cat("Oma", List.of(Colors.WHITE, Colors.BLACK), 2);
        Animal cat2Ivan = new Cat("Apple", List.of(Colors.ECRU, Colors.WHITE), 0);
        Animal dogIvan = new Dog("Harry", List.of(Colors.BROWN, Colors.BLACK), 4);
        Animal ratIvan = new Rat("Baka", List.of(Colors.GREY), 1);
        Animal fishIvan = new Fish("Bul", List.of(Colors.RED), 1);

        Animal rabbitTamara = new Rabbit("Skock", List.of(Colors.ECRU), 1);

        Person ownerIvan = new Person("Ivan", "Kolobkov");
        Person ownerTamara = new Person("Tamara", "Palkina");

        Relation allOwnersAnimalsRelations = new Relation();
        allOwnersAnimalsRelations.addRelation(ownerIvan, List.of(catIvan, cat2Ivan, dogIvan, ratIvan, fishIvan));
        allOwnersAnimalsRelations.addRelation(ownerTamara, rabbitTamara);

//        allOwnersAnimalsRelations.printAllAnimals(ownerIvan);
//        allOwnersAnimalsRelations.printAllAnimals(ownerTamara);

        allOwnersAnimalsRelations.makeSoundСommand(ownerIvan, Dog.class);
        System.out.println();
        allOwnersAnimalsRelations.makeSoundСommand(ownerIvan, List.of(Cat.class, Fish.class));

        allOwnersAnimalsRelations.makeComeСommand(ownerIvan, List.of(Dog.class, Fish.class, Rabbit.class));
        System.out.println();

        allOwnersAnimalsRelations.makeComeСommand(ownerTamara, Rabbit.class, 3);
        System.out.println();
        allOwnersAnimalsRelations.makeComeСommand(ownerIvan, catIvan, 7);
        System.out.println();
        allOwnersAnimalsRelations.makeComeСommand(ownerIvan, cat2Ivan);
    }
}

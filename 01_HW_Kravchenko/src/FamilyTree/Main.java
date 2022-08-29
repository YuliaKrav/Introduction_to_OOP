package FamilyTree;

//Реализовать, с учетом ооп подхода, приложение Для проведения исследований с генеалогическим древом. Идея: описать некоторое количество компонент,
//        например: модель человека компонента хранения связей и отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение,
//        брат, свекровь, сестра и т. д. компонент для проведения исследований дополнительные компоненты, например отвечающие за вывод данных в консоль,
//        загрузку и сохранения в файл, получение\построение отдельных моделей человека Под “проведением исследования” можно понимать получение всех
//        детей выбранного человека.

import java.util.List;


public class Main {
    static Person grandpaMother = new Person("Gregory", "White", 65, GenderType.MAN);
    static Person grandmaMother = new Person("Ryvka", "White", 65, GenderType.WOMAN);

    static Person grandpaFather = new Person("Petr", "Chernov", 70, GenderType.MAN);
    static Person grandmaFather = new Person("Olga", "Chernova", 60, GenderType.WOMAN);

    static Person aunt = new Person("Vera", "Kolova", 35, GenderType.WOMAN);
    static Person auntSon = new Person("Boris", "Kolov", 4, GenderType.MAN);

    static Person mother = new Person("Maria", "White", 35, GenderType.WOMAN);
    static Person father = new Person("Igor", "Chernov", 37, GenderType.MAN);

    static Person son1 = new Person("Oleg", "Chernov", 7, GenderType.MAN);
    static Person son2 = new Person("Jeroen", "White", 12, GenderType.MAN);
    static Person daughter = new Person("Olesya", "Chernova", 4, GenderType.WOMAN);

    public static void main(String[] args) {
       SearchForRelations workWithRelations = fillDataFamilyTree();

//        System.out.println(workWithRelations.findRelationType(daughter, AllRelationTypes.GRANDMOTHER));
//        System.out.println(workWithRelations.findRelationType(daughter, AllRelationTypes.GRANDFATHER));
//        System.out.println(workWithRelations.findRelationType(son1, AllRelationTypes.BROTHER));
//        System.out.println(workWithRelations.findRelationType(daughter, AllRelationTypes.AUNT));
//        System.out.println(workWithRelations.findRelationType(daughter, AllRelationTypes.MOTHER));
//        System.out.println(workWithRelations.findRelationType(mother, List.of(AllRelationTypes.SON, AllRelationTypes.DAUGHTER)));
//        System.out.println(workWithRelations.findRelationType(father, AllRelationTypes.NEPHEW));
//        System.out.println(workWithRelations.findRelationType(aunt, AllRelationTypes.NEPHEW));

        System.out.println();
        workWithRelations.findRelationType(daughter, AllRelationTypes.GRANDMOTHER);
        System.out.println();
        workWithRelations.findRelationType(daughter, List.of(AllRelationTypes.GRANDMOTHER, AllRelationTypes.GRANDFATHER));
        System.out.println();
        workWithRelations.findRelationType(aunt, AllRelationTypes.NEPHEW);
        System.out.println();
        workWithRelations.findRelationType(daughter, AllRelationTypes.AUNT);
        System.out.println();
        workWithRelations.findRelationType(auntSon, AllRelationTypes.SISTER);
        //workWithRelations.printRelations();

    }

    public static SearchForRelations fillDataFamilyTree() {
        SearchForRelations searchForRelations = new SearchForRelations();

        searchForRelations.addRelation(new PeopleRelations(grandmaMother, mother, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(mother, grandmaMother, KeyRelationsTypes.CHILD));
        searchForRelations.addRelation(new PeopleRelations(grandpaMother, mother, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(mother, grandpaMother, KeyRelationsTypes.CHILD));

        searchForRelations.addRelation(new PeopleRelations(grandmaFather, father, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(father, grandmaFather, KeyRelationsTypes.CHILD));
        searchForRelations.addRelation(new PeopleRelations(grandpaFather, father, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(father, grandpaFather, KeyRelationsTypes.CHILD));

        searchForRelations.addRelation(new PeopleRelations(grandmaFather, aunt, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(aunt, grandmaFather, KeyRelationsTypes.CHILD));
        searchForRelations.addRelation(new PeopleRelations(grandpaFather, aunt, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(aunt, grandpaFather, KeyRelationsTypes.CHILD));

        searchForRelations.addRelation(new PeopleRelations(mother, son1, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(son1, mother, KeyRelationsTypes.CHILD));
        searchForRelations.addRelation(new PeopleRelations(father, son1, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(son1, father, KeyRelationsTypes.CHILD));

        searchForRelations.addRelation(new PeopleRelations(mother, son2, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(son2, mother, KeyRelationsTypes.CHILD));
        searchForRelations.addRelation(new PeopleRelations(father, son2, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(son2, father, KeyRelationsTypes.CHILD));

        searchForRelations.addRelation(new PeopleRelations(mother, daughter, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(daughter, mother, KeyRelationsTypes.CHILD));
        searchForRelations.addRelation(new PeopleRelations(father, daughter, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(daughter, father, KeyRelationsTypes.CHILD));

        searchForRelations.addRelation(new PeopleRelations(aunt, auntSon, KeyRelationsTypes.PARENT));
        searchForRelations.addRelation(new PeopleRelations(auntSon, aunt, KeyRelationsTypes.CHILD));

        return searchForRelations;
    }
}

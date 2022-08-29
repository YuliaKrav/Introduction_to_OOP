package FamilyTree;

public class PeopleRelations {
    private Person personOne;
    private Person personTwo;
    private KeyRelationsTypes keyRelationsType;

    public PeopleRelations(Person personOne, Person personTwo, KeyRelationsTypes keyRelationsType) {
        this.personOne = personOne;
        this.personTwo = personTwo;
        this.keyRelationsType = keyRelationsType;
    }

    public Person getPersonOne() {
        return personOne;
    }

    public Person getPersonTwo() {
        return personTwo;
    }

    public KeyRelationsTypes getKeyRelationsType() {
        return keyRelationsType;
    }

    public String getOneRelationString() {
        return "person 1 " + personOne + " is a " + keyRelationsType + " of a person 2 " + personTwo;
    }
}

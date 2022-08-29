package FamilyTree;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private GenderType gender;

    public Person(String name, String lastName, int age, GenderType gender) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public GenderType getGender() {
        return gender;
    }

    boolean peopleAreEqual(Person person) {
        return (this.name.equals(person.getName()) &&
                this.lastName.equals(person.getLastName()) &&
                this.age == person.getAge() &&
                this.gender == person.getGender());
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }
}

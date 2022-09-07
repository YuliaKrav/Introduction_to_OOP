package itempackage;


import personpackage.Person;
import totalenums.ColorEnum;

public class Item {
    private String name;
    private ColorEnum color;
    Person owner;

    public Item(String name, ColorEnum color, Person owner) {
        this.name = name;
        this.color = color;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return (color + " " + name).toLowerCase();
    }
}

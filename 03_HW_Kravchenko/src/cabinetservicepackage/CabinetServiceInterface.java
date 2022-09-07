package cabinetservicepackage;

import cabinetpackage.Cabinet;
import itempackage.Item;
import personpackage.Person;

import java.util.List;

public interface CabinetServiceInterface {

    boolean canBeOpened(Cabinet cabinet, Person person);

    void open(Cabinet cabinet, Person person);

    void close(Cabinet cabinet, Person person);

    void putItem(Cabinet cabinet, Person person, Item item);

    void putItem(Cabinet cabinet, Person person, List<Item> itemList);

    void takeOutItem(Cabinet cabinet, Person person, Item item);
}

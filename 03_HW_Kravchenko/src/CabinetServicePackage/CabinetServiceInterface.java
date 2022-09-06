package CabinetServicePackage;

import CabinetPackage.Cabinet;
import ItemPackage.Item;
import PersonPackage.Person;

import java.util.List;

public interface CabinetServiceInterface {

    boolean canBeOpened(Cabinet cabinet, Person person);

    void open(Cabinet cabinet, Person person);

    void close(Cabinet cabinet, Person person);

    void putItem(Cabinet cabinet, Person person, Item item);

    void putItem(Cabinet cabinet, Person person, List<Item> itemList);

    void takeOutItem(Cabinet cabinet, Person person, Item item);
}

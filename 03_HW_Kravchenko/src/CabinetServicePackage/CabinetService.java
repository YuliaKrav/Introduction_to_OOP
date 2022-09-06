package CabinetServicePackage;

import CabinetPackage.Cabinet;
import ItemPackage.Item;
import PersonPackage.Person;

import java.util.List;

public class CabinetService implements CabinetServiceInterface {
    @Override
    public boolean canBeOpened(Cabinet cabinet, Person person) {
        return person.getWardrobeKeyMap().containsKey(cabinet.getKey());
    }

    @Override
    public void open(Cabinet cabinet, Person person) {
        if (cabinet.isOpenStatus()) {
            System.out.println(cabinet + " is already open.");
        } else if (canBeOpened(cabinet, person)) {
            cabinet.setOpenStatus(true);
            System.out.println(person + " opens " + cabinet.printCabinetOpenClosePart() + " of the " + cabinet);
        } else {
            System.out.println(person + " can't open " + cabinet.printCabinetOpenClosePart() + " of the " + cabinet);
        }
    }

    @Override
    public void close(Cabinet cabinet, Person person) {
        cabinet.setOpenStatus(false);
        System.out.println(person + " closes " + cabinet.printCabinetOpenClosePart() + " of the " + cabinet);
    }

    @Override
    public void putItem(Cabinet cabinet, Person person, Item item) {
        boolean needToBeClosed = true;
        putItemAction(cabinet, person, item, needToBeClosed);
    }

    @Override
    public void putItem(Cabinet cabinet, Person person, List<Item> itemList) {
        for (int i = 0; i < itemList.size(); i++) {
            boolean lastItem = i == itemList.size() - 1;
            putItemAction(cabinet, person, itemList.get(i), lastItem);
        }
    }

    @Override
    public void takeOutItem(Cabinet cabinet, Person person, Item item) {
        open(cabinet, person);
        if (cabinet.isOpenStatus()) {
            if (isItemInside(cabinet, item)) {
                cabinet.removeItem(item);
                System.out.println(person + " take the " + item + " out of the " + cabinet);
                close(cabinet, person);
            } else {
                System.out.println("and looks for the " + item + " but it is not there.");
                //Здесь дверь забывают закрыть
            }
        } else {
            System.out.println(person + " can't take the " + item + " out of the " + cabinet + " because he(she) doesn't have the key.");
        }
    }

    private void putItemAction(Cabinet cabinet, Person person, Item item, boolean needToBeClosed) {
//        open(cabinet, person);
//        if (cabinet.isOpenStatus()) {
        if (canPutItem(cabinet, person)) {
            cabinet.addItem(item);
            System.out.println(person + " put the " + item + " in the " + cabinet);
            if (needToBeClosed) {
                close(cabinet, person);
            }
        } else {
            System.out.println(person + " can't put the " + item + " in the " + cabinet + " because he(she) doesn't have the key.");
        }
    }

    private boolean canPutItem(Cabinet cabinet, Person person) {
        if (cabinet.isOpenStatus()) {
            return true;
        }
        if (canBeOpened(cabinet, person)) {
            open(cabinet, person);
            return true;
        }
        return false;
    }

    private boolean isItemInside(Cabinet cabinet, Item item) {
        return cabinet.getItemList().contains(item);
    }
}

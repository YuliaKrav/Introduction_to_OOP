package CabinetPackage;

import CabinetActionsPackage.CabinetOpenClosePartInterface;
import ItemPackage.Item;
import TotalEnums.ColorEnum;
import TotalEnums.SizeEnum;

import java.util.ArrayList;
import java.util.List;

public abstract class Cabinet {
    static int countTotal = 0;
    CabinetOpenClosePartInterface cabinetOpenClosePart;

    private int id;
    private ColorEnum color;
    private SizeEnum size;
    private boolean isOpenStatus;
    CabinetKey key;
    List<Item> itemList;

    public Cabinet(ColorEnum color, SizeEnum size) {
        countTotal++;
        this.id = countTotal;
        this.color = color;
        this.size = size;
        this.isOpenStatus = false;
        this.key = new CabinetKey();
        itemList = new ArrayList<>();
    }

    public CabinetKey getKey() {
        return key;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public boolean isOpenStatus() {
        return isOpenStatus;
    }

    public void setOpenStatus(boolean openStatus) {
        isOpenStatus = openStatus;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

    @Override
    public String toString() {
        return (size + " " + color).toLowerCase() + " " + getCabinetType(this) + " №" + id;
    }

    public String printCabinetOpenClosePart() {
        return cabinetOpenClosePart.nameOpeningCabinetPart();
    }

    private String getCabinetType(Cabinet cabinet) {
        return cabinet.getClass().getSimpleName().toLowerCase();
    }
}

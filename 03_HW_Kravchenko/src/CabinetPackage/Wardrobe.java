package CabinetPackage;

import CabinetActionsPackage.DoorsOpenClose;
import TotalEnums.ColorEnum;
import TotalEnums.SizeEnum;

public class Wardrobe extends Cabinet {
    public Wardrobe(ColorEnum color, SizeEnum size) {
        super(color, size);
        cabinetOpenClosePart = new DoorsOpenClose();
    }
}

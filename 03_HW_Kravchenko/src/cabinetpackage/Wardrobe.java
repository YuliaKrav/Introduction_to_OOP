package cabinetpackage;

import cabinetactionspackage.DoorsOpenClose;
import totalenums.ColorEnum;
import totalenums.SizeEnum;

public class Wardrobe extends Cabinet {
    public Wardrobe(ColorEnum color, SizeEnum size) {
        super(color, size);
        cabinetOpenClosePart = new DoorsOpenClose();
    }
}

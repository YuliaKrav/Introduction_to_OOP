package cabinetpackage;

import cabinetactionspackage.DrawersOpenClose;
import totalenums.ColorEnum;
import totalenums.SizeEnum;

public class Commode extends Cabinet {
    public Commode(ColorEnum color, SizeEnum size) {
        super(color, size);
        cabinetOpenClosePart = new DrawersOpenClose();
    }
}

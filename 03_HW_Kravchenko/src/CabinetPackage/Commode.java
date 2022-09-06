package CabinetPackage;

import CabinetActionsPackage.DrawersOpenClose;
import TotalEnums.ColorEnum;
import TotalEnums.SizeEnum;

public class Commode extends Cabinet {
    public Commode(ColorEnum color, SizeEnum size) {
        super(color, size);
        cabinetOpenClosePart = new DrawersOpenClose();
    }
}

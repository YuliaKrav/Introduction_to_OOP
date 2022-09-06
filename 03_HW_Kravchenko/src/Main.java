import CabinetPackage.Cabinet;
import CabinetPackage.Commode;
import CabinetPackage.Wardrobe;
import CabinetServicePackage.CabinetService;
import ItemPackage.Item;
import PersonPackage.Person;
import PersonServicePackage.PersonService;
import TotalEnums.ColorEnum;
import TotalEnums.SizeEnum;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person Igor = new Person("Igor", "Petrov");
        Person Masha = new Person("Masha", "Petrova");

        Cabinet wardrobeGreen = new Wardrobe(ColorEnum.GREEN, SizeEnum.LARGE);
        Cabinet commodeYellow = new Commode(ColorEnum.YELLOW, SizeEnum.SMALL);

        Item ballIgor = new Item("ball", ColorEnum.RED, Igor);
        Item ball2Igor = new Item("ball", ColorEnum.BLUE, Igor);
        Item ball3Igor = new Item("ball", ColorEnum.GRAY, Igor);

        PersonService personService = new PersonService();
        CabinetService cabinetService = new CabinetService();

        personService.takeKey(Igor, wardrobeGreen);
        personService.takeKey(Masha, commodeYellow);

        System.out.println();
        cabinetService.putItem(wardrobeGreen, Igor, List.of(ballIgor, ball2Igor));
        System.out.println();
//        System.out.println(wardrobeGreen.getItemList());
        cabinetService.takeOutItem(wardrobeGreen, Igor, ball3Igor);
        System.out.println();
        cabinetService.takeOutItem(wardrobeGreen, Igor, ball2Igor);
        System.out.println();
//        System.out.println(wardrobeGreen.getItemList());

        cabinetService.putItem(commodeYellow, Masha, ball3Igor);
        System.out.println();
        cabinetService.takeOutItem(commodeYellow, Igor, ball3Igor);
        System.out.println();
        personService.givePersonKey(Masha, commodeYellow, Igor);
        System.out.println();
        cabinetService.takeOutItem(commodeYellow, Igor, ball3Igor);


    }
}

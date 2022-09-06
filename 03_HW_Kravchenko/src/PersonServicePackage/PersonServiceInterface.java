package PersonServicePackage;

import CabinetPackage.Cabinet;
import PersonPackage.Person;

public interface PersonServiceInterface {
    void givePersonKey(Person personFrom, Cabinet cabinet, Person personTo);

    void takeKey(Person person, Cabinet cabinet);
}

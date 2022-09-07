package personservicepackage;

import cabinetpackage.Cabinet;
import personpackage.Person;

public interface PersonServiceInterface {
    void givePersonKey(Person personFrom, Cabinet cabinet, Person personTo);

    void takeKey(Person person, Cabinet cabinet);
}

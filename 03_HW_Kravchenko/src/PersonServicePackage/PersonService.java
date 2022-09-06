package PersonServicePackage;

import CabinetPackage.Cabinet;
import PersonPackage.Person;

public class PersonService implements PersonServiceInterface {
    @Override
    public void givePersonKey(Person personFrom, Cabinet cabinet, Person personTo) {
        if (personFrom.getWardrobeKeyMap().containsKey(cabinet.getKey())) {
            personTo.addKey(cabinet.getKey());
            personFrom.removeKey(cabinet.getKey());
            System.out.println(personFrom + " gives the key from the " + cabinet + " to " + personTo);
        } else {
            System.out.println(personFrom + " can't give the key from the " + cabinet + " to " + personTo + "because he(she) doesn't have it");
        }
    }

    @Override
    public void takeKey(Person person, Cabinet cabinet) {
        person.addKey(cabinet.getKey());
        System.out.println(person + " take the key from the " + cabinet);
    }
}

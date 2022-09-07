package personpackage;

import cabinetpackage.CabinetKey;

import java.util.HashMap;
import java.util.Map;

public class Person {
    private final String name;
    private final String lastName;
    private Map<CabinetKey, Integer> cabinetKeyMap;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        cabinetKeyMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Map<CabinetKey, Integer> getWardrobeKeyMap() {
        return cabinetKeyMap;
    }

    public void addKey(CabinetKey key) {
        cabinetKeyMap.putIfAbsent(key, 0);
        cabinetKeyMap.compute(key, (k, v) -> v + 1);
        //wardrobeKeyMap.put(key, wardrobeKeyMap.get(key) + 1);
    }

    public void removeKey(CabinetKey key) {
        cabinetKeyMap.computeIfPresent(key, (k, v) -> v - 1);

        if (cabinetKeyMap.containsKey(key) && cabinetKeyMap.get(key) == 0) {
            cabinetKeyMap.remove(key);
        }
    }

    @Override
    public String toString() {
        return getName() + " " + getLastName();
    }
}

package FamilyTree;

import java.util.*;
import java.util.stream.Collectors;

public class SearchForRelations {
    private List<PeopleRelations> peopleRelationsList;
    private static Map<AllRelationTypes, FieldsForMovivgToFindRelation> movingMap;

    static {
        movingMap = new HashMap<>();
        movingMap.put(AllRelationTypes.GRANDFATHER, new FieldsForMovivgToFindRelation(2, 0, GenderType.MAN, true));
        movingMap.put(AllRelationTypes.GRANDMOTHER, new FieldsForMovivgToFindRelation(2, 0, GenderType.WOMAN, true));
        movingMap.put(AllRelationTypes.BROTHER, new FieldsForMovivgToFindRelation(1, 1, GenderType.MAN, true));
        movingMap.put(AllRelationTypes.SISTER, new FieldsForMovivgToFindRelation(1, 1, GenderType.WOMAN, true));
        movingMap.put(AllRelationTypes.UNCLE, new FieldsForMovivgToFindRelation(2, 1, GenderType.MAN, false));
        movingMap.put(AllRelationTypes.AUNT, new FieldsForMovivgToFindRelation(2, 1, GenderType.WOMAN, false));
        movingMap.put(AllRelationTypes.FATHER, new FieldsForMovivgToFindRelation(1, 0, GenderType.MAN, true));
        movingMap.put(AllRelationTypes.MOTHER, new FieldsForMovivgToFindRelation(1, 0, GenderType.WOMAN, true));
        movingMap.put(AllRelationTypes.SON, new FieldsForMovivgToFindRelation(0, 1, GenderType.MAN, true));
        movingMap.put(AllRelationTypes.DAUGHTER, new FieldsForMovivgToFindRelation(0, 1, GenderType.WOMAN, true));
        movingMap.put(AllRelationTypes.NEPHEW, new FieldsForMovivgToFindRelation(1, 2, GenderType.MAN, false));
    }


    public SearchForRelations() {
        peopleRelationsList = new ArrayList<>();
    }


    public void addRelation(PeopleRelations peopleRelations) {
        peopleRelationsList.add(peopleRelations);
    }


    private HashSet<Person> finderAllRelationType(HashSet<Person> setToCheck, int up, int down) {
        HashSet<Person> copySetToCheck = new HashSet<>(setToCheck);
        KeyRelationsTypes relationType = KeyRelationsTypes.PARENT;

        if (up == 0 && down != 0) {
            up = down;
            down = 0;
            relationType = KeyRelationsTypes.PARENT == relationType ? KeyRelationsTypes.CHILD : KeyRelationsTypes.PARENT;
        }

        while (up != 0 || down != 0) {
            HashSet<Person> newSetToCheck = new HashSet<>();
            for (Person person : copySetToCheck) {
                for (PeopleRelations relation : peopleRelationsList) {
                    if (relation.getPersonTwo().peopleAreEqual(person) && relation.getKeyRelationsType() == relationType) {
                        newSetToCheck.add(relation.getPersonOne());
                    }
                }
            }
            copySetToCheck.clear();
            copySetToCheck.addAll(newSetToCheck);
            up--;
            if (up == 0 && down != 0) {
                up = down;
                down = 0;
                relationType = KeyRelationsTypes.PARENT == relationType ? KeyRelationsTypes.CHILD : KeyRelationsTypes.PARENT;
            }
        }
        return copySetToCheck;
    }


    private HashSet<Person> finderAllGenderType(HashSet<Person> setToCheck, GenderType genderType) {
        HashSet<Person> resultSetGender = new HashSet<>();

        for (Person person : setToCheck) {
            if (person.getGender() == genderType) {
                resultSetGender.add(person);
            }
        }
        return resultSetGender;
    }


    private HashSet<Person> deleteDirectRelation(Person person, HashSet<Person> setToCheck, int up, int down) {
        HashSet<Person> resultTotalSet = new HashSet<>(setToCheck);
        HashSet<Person> nodeToCheck = new HashSet<>();
        nodeToCheck.add(person);
        int levelForCheck = up - down;

        if (levelForCheck > 0) {
            resultTotalSet.removeAll(finderAllRelationType(nodeToCheck, levelForCheck, 0));
        } else {
            resultTotalSet.removeAll(finderAllRelationType(nodeToCheck, 0, -levelForCheck));
        }
        return resultTotalSet;
    }


    public HashSet<Person> findRelationType(Person person, AllRelationTypes relationType) {
        int stepUP = movingMap.get(relationType).getUp();
        int stepDown = movingMap.get(relationType).getDown();
        GenderType findPersonGender = movingMap.get(relationType).getGender();
        HashSet<Person> nodeToCheck = new HashSet<>();
        nodeToCheck.add(person);

        HashSet<Person> resultSet = finderAllRelationType(nodeToCheck, stepUP, stepDown);
        resultSet = finderAllGenderType(resultSet, findPersonGender);
        if (!movingMap.get(relationType).isDirectRelationIncludes()) {
            resultSet = deleteDirectRelation(person, resultSet, stepUP, stepDown);
        }
        printOnePersonResult(person, relationType, resultSet);
        return resultSet;
    }


    public HashSet<Person> findRelationType(Person person, List<AllRelationTypes> relationTypeList) {
        HashSet<Person> resultUnionSet = new HashSet<>();

        for (AllRelationTypes relation : relationTypeList) {
            resultUnionSet.addAll(findRelationType(person, relation));
        }
        return resultUnionSet;
    }

    private void printOnePersonResult(Person person, AllRelationTypes relationType, HashSet<Person> resultSet) {
        String resultString = resultSet.size() != 0 ?
                resultSet.stream().map(Person::toString).collect(Collectors.joining(", ")) :
                "Nobody";
        resultString += " is/are the " + relationType + " of " + person.toString();
        System.out.println(resultString);
    }

    public void printRelations() {
        for (PeopleRelations relation : peopleRelationsList) {
            System.out.println(relation.getOneRelationString());
        }
    }
}

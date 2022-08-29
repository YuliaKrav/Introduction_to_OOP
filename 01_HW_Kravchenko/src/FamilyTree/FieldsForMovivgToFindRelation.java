package FamilyTree;

public class FieldsForMovivgToFindRelation {
    private int up;
    private int down;
    private GenderType gender;
    private boolean isDirectRelationIncludes;

    public FieldsForMovivgToFindRelation(int up, int down, GenderType gender, boolean isDirectRelationIncludes) {
        this.up = up;
        this.down = down;
        this.gender = gender;
        this.isDirectRelationIncludes = isDirectRelationIncludes;

    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public GenderType getGender() {
        return gender;
    }

    public boolean isDirectRelationIncludes() {
        return isDirectRelationIncludes;
    }
}

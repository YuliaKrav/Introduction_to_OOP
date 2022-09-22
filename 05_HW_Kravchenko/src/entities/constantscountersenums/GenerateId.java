package entities.constantscountersenums;

public class GenerateId {
    private static int idDocumentCounter = 0;
    private static int idProjectCounter = 0;

    public static int getIdDocumentCounter() {
        return idDocumentCounter++;
    }

    public static int getIdProjectCounter() {
        return idProjectCounter++;
    }


}

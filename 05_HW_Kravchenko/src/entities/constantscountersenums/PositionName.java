package entities.constantscountersenums;

import java.util.ArrayList;
import java.util.List;

public class PositionName {
    private static final String DIRECTOR_POSITION_NAME = "CEO";
    private static final String TOP_MANAGER_POSITION_NAME = "top manager";
    private static final String MANAGER_POSITION_NAME = "manager";
    private static final String HR_SPECIALIST_POSITION_NAME = "HR specialist";
    private static final String OPERATOR_POSITION_NAME = "operator";
    private static final String DRIVER_POSITION_NAME = "driver";
    private static final String CLEANER_POSITION_NAME = "cleaning specialist";
    private static final String TESTER_POSITION_NAME = "tester";
    private static final String DEVELOPER_POSITION_NAME = "developer";

    private List<String> allCompanyPositions;

    public PositionName(List<String> allCompanyPositions) {
        this.allCompanyPositions = new ArrayList<>();
        allCompanyPositions.add(DIRECTOR_POSITION_NAME);
        allCompanyPositions.add(TOP_MANAGER_POSITION_NAME);
        allCompanyPositions.add(MANAGER_POSITION_NAME);
        allCompanyPositions.add(HR_SPECIALIST_POSITION_NAME);
        allCompanyPositions.add(OPERATOR_POSITION_NAME);
        allCompanyPositions.add(DRIVER_POSITION_NAME);
        allCompanyPositions.add(CLEANER_POSITION_NAME);
        allCompanyPositions.add(TESTER_POSITION_NAME);
        allCompanyPositions.add(DEVELOPER_POSITION_NAME);
    }

    public static String getDIRECTOR_POSITION_NAME() {
        return DIRECTOR_POSITION_NAME;
    }

    public static String getTOP_MANAGER_POSITION_NAME() {
        return TOP_MANAGER_POSITION_NAME;
    }

    public static String getMANAGER_POSITION_NAME() {
        return MANAGER_POSITION_NAME;
    }

    public static String getHR_SPECIALIST_POSITION_NAME() {
        return HR_SPECIALIST_POSITION_NAME;
    }

    public static String getOPERATOR_POSITION_NAME() {
        return OPERATOR_POSITION_NAME;
    }

    public static String getDRIVER_POSITION_NAME() {
        return DRIVER_POSITION_NAME;
    }

    public static String getCLEANER_POSITION_NAME() {
        return CLEANER_POSITION_NAME;
    }

    public static String getTESTER_POSITION_NAME() {
        return TESTER_POSITION_NAME;
    }

    public static String getDEVELOPER_POSITION_NAME() {
        return DEVELOPER_POSITION_NAME;
    }


    public List<String> getAllCompanyPositions() {
        return allCompanyPositions;
    }
}

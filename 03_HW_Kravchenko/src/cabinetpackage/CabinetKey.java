package cabinetpackage;

import java.util.UUID;

public class CabinetKey {
    private String keyId;

    public CabinetKey() {
        this.keyId = UUID.randomUUID().toString();
    }
}

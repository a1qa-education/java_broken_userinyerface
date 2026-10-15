package constants;

public enum Domains {
    ORG,
    CO_UK(".co.uk"),
    NET,
    GOV,
    DE,
    FR,
    NL,
    COM,
    BE,
    JPG;

    private final String explicitValue;

    Domains(String explicitValue) {
        this.explicitValue = explicitValue;
    }

    Domains() {
        this.explicitValue = null;
    }

    public String getDomain() {
        return explicitValue != null ? explicitValue : "." + name().toLowerCase().replace("_", ".");
    }
}

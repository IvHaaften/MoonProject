package MaanProject.constants;

public enum DelfstofType {
    HELIUM3(false), IRIDIUM(true), REGOLIET(false), GOUD(false), PALLADIUM(false), PLATINA(false);
    private final boolean radioactief;

    public boolean isRadioactief() {
        return radioactief;
    }

    DelfstofType(boolean radioactief) {
        this.radioactief = radioactief;
    }
}

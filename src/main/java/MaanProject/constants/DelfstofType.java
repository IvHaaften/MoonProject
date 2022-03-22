package MaanProject.constants;

import java.util.List;

public class DelfstofType {
    public static final Delfstof HELIUM3 = Delfstof.builder()
            .elementnaam("Helium3")
            .elementnummer(2)
            .stofdichtheid(0.1346)
            .radioactief(false)
            .build();
    public static final Delfstof IRIDIUM = Delfstof.builder()
            .elementnaam("Helium")
            .elementnummer(77)
            .stofdichtheid(0.1346)
            .radioactief(true)
            .build();
    public static final Delfstof REGOLIET = Delfstof.builder()
            .elementnaam("Regoliet")
            .stofdichtheid(1.5)
            .radioactief(false)
            .build();
    public static final Delfstof GOUD = Delfstof.builder()
            .elementnaam("Goud")
            .elementnummer(79)
            .stofdichtheid(0.2)
            .radioactief(false)
            .build();
    public static final Delfstof PALLADIUM = Delfstof.builder()
            .elementnaam("Palladium")
            .elementnummer(5)
            .stofdichtheid(11.9)
            .radioactief(false)
            .build();
    public static final Delfstof PLATINA = Delfstof.builder()
            .elementnaam("Platina")
            .elementnummer(6)
            .stofdichtheid(0.5)
            .radioactief(false)
            .build();

    public static List<Delfstof> values () {
        return List.of(DelfstofType.IRIDIUM, DelfstofType.PALLADIUM, DelfstofType.HELIUM3, DelfstofType.REGOLIET
                , DelfstofType.GOUD, DelfstofType.PLATINA);
    }

}

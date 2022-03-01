package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;
import MaanProject.constants.GewasType;
import MaanProject.constants.Vergunning;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.awt.*;
import java.util.Optional;

@Entity
@DiscriminatorValue("LANDBOUW")
@NoArgsConstructor()
public class LandbouwPerceel extends Perceel {

    private GewasType gewas;
    private int jaarOpbrengst;

    @OneToOne
    private Vergunning<GewasType> vergunning;

    public LandbouwPerceel(Polygon begrenzing, Inwoner eigenaar, GewasType gewas, int jaarOpbrengst, Optional<Vergunning<GewasType>> optioneleVergunning) {
        super(begrenzing, eigenaar);
        this.gewas = gewas;
        this.jaarOpbrengst = jaarOpbrengst;
        setvergunning(optioneleVergunning);
    }

    public GewasType getGewas() {
        return gewas;
    }

    public void setGewas(GewasType gewas) {
        this.gewas = gewas;
    }

    public int getJaarOpbrengst() {
        return jaarOpbrengst;
    }

    public void setJaarOpbrengst(int jaarOpbrengst) {
        this.jaarOpbrengst = jaarOpbrengst;
    }

    public Optional<Vergunning<GewasType>> getvergunning() {
        return Optional.ofNullable(vergunning);
    }

    public void setvergunning(Vergunning<GewasType> vergunning) {
        this.vergunning = vergunning;
    }

    public void setvergunning(Optional<Vergunning<GewasType>> optioneleVergunning) {
        vergunning = optioneleVergunning.orElse(null);
    }
}

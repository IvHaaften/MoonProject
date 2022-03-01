package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;
import MaanProject.constants.DelfstofType;
import MaanProject.constants.Vergunning;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.awt.*;
import java.util.Optional;

@Entity
@DiscriminatorValue("MIJN")
@NoArgsConstructor()
public class MijnbouwPerceel extends Perceel {

    private DelfstofType delfstof;
    private int jaarOpbrengst;

    @OneToOne
    private Vergunning<DelfstofType> vergunning;

    public MijnbouwPerceel(Polygon begrenzing, Inwoner eigenaar, DelfstofType delfstof, int jaarOpbrengst, Optional<Vergunning<DelfstofType>> optioneleVergunning) {
        super(begrenzing, eigenaar);
        this.delfstof = delfstof;
        this.jaarOpbrengst = jaarOpbrengst;
        setvergunning(optioneleVergunning);
    }

    public DelfstofType getDelfstof() {
        return delfstof;
    }

    public void setDelfstof(DelfstofType delfstof) {
        this.delfstof = delfstof;
    }

    public int getJaarOpbrengst() {
        return jaarOpbrengst;
    }

    public void setJaarOpbrengst(int jaarOpbrengst) {
        this.jaarOpbrengst = jaarOpbrengst;
    }

    public Optional getvergunning() {
        return Optional.ofNullable(vergunning);
    }

    public void setvergunning(Vergunning<DelfstofType> vergunning) {
        this.vergunning = vergunning;
    }

    public void setvergunning(Optional<Vergunning<DelfstofType>> optioneleVergunning) {
        vergunning = optioneleVergunning.orElse(null);
    }
}

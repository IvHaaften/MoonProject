package MaanProject.Models.PerceelTypes;

import MaanProject.Models.Inwoner;
import MaanProject.Models.Perceel;
import MaanProject.constants.Delfstof;
import MaanProject.constants.Vergunning;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.awt.*;
import java.util.Optional;

@Entity
@Getter
@DiscriminatorValue("MIJN")
@NoArgsConstructor()
public class MijnbouwPerceel extends Perceel {

    @ManyToOne
    private Delfstof delfstof;
    private int jaarOpbrengst;

    @OneToOne
    private Vergunning<Delfstof> vergunning;

    public MijnbouwPerceel(Polygon begrenzing, Inwoner eigenaar, Delfstof delfstof, int jaarOpbrengst, Optional<Vergunning<Delfstof>> optioneleVergunning) {
        super(begrenzing, eigenaar);
        this.delfstof = delfstof;
        this.jaarOpbrengst = jaarOpbrengst;
        setvergunning(optioneleVergunning);
    }

    public void setDelfstof(Delfstof delfstof) {
        this.delfstof = delfstof;
    }

    public void setJaarOpbrengst(int jaarOpbrengst) {
        this.jaarOpbrengst = jaarOpbrengst;
    }

    public Optional getvergunning() {
        return Optional.ofNullable(vergunning);
    }

    public void setvergunning(Vergunning<Delfstof> vergunning) {
        this.vergunning = vergunning;
    }

    public void setvergunning(Optional<Vergunning<Delfstof>> optioneleVergunning) {
        vergunning = optioneleVergunning.orElse(null);
    }
}

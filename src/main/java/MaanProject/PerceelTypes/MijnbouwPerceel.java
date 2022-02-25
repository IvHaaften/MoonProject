package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;
import MaanProject.constants.DelfstofType;
import MaanProject.constants.Vergunning;
import java.util.Optional;
import javax.persistence.OneToOne;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.awt.*;

@Entity
@DiscriminatorValue("MIJN")
@NoArgsConstructor()
public class MijnbouwPerceel extends Perceel {

    private DelfstofType delfstof;
    private int jaarOpbrengst;

	@OneToOne
    private Optional<Vergunning<DelfstofType>> optionalVergunning;

    public MijnbouwPerceel(Polygon begrenzing, Inwoner eigenaar, DelfstofType delfstof, int jaarOpbrengst, Optional<Vergunning<DelfstofType>> optionalVergunning) {
        super(begrenzing, eigenaar);
        this.delfstof = delfstof;
        this.jaarOpbrengst = jaarOpbrengst;
		this.optionalVergunning = optionalVergunning;
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
}

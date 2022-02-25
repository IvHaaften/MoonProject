package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;
import MaanProject.constants.GewasType;
import MaanProject.constants.Vergunning;
import java.util.Optional;
import javax.persistence.OneToOne;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.awt.*;

@Entity
@DiscriminatorValue("LANDBOUW")
@NoArgsConstructor()
public class LandbouwPerceel extends Perceel {

    private GewasType gewas;
    private int jaarOpbrengst;

    @OneToOne
    private Optional<Vergunning<GewasType>> optionalVergunning;

    public LandbouwPerceel(Polygon begrenzing, Inwoner eigenaar, GewasType gewas, int jaarOpbrengst, Optional<Vergunning<GewasType>> optionalVergunning) {
        super(begrenzing, eigenaar);
        this.gewas = gewas;
        this.jaarOpbrengst = jaarOpbrengst;
		this.optionalVergunning = optionalVergunning;
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
}

package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;
import MaanProject.constants.DelfstofType;

import javax.persistence.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("MIJN")
public class MijnbouwPerceel extends Perceel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private DelfstofType delfstof;
    private int jaarOpbrengst;

    public MijnbouwPerceel(Polygon begrenzing, Inwoner eigenaar, DelfstofType delfstof, int jaarOpbrengst) {
        super(begrenzing, eigenaar);
        this.delfstof = delfstof;
        this.jaarOpbrengst = jaarOpbrengst;
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

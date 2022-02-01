package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;
import MaanProject.constants.DelfstofType;

import java.util.List;
import java.util.Map;

public class MijnbouwPerceel extends Perceel {
    private DelfstofType delfstof;
    private int jaarOpbrengst;

    public MijnbouwPerceel(List<Map<Double, Double>> begrenzing, Inwoner eigenaar, DelfstofType delfstof, int jaarOpbrengst) {
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

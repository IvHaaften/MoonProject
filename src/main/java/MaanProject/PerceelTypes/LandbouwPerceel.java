package MaanProject.PerceelTypes;

import MaanProject.Perceel;
import MaanProject.constants.GewasType;

public class LandbouwPerceel extends Perceel {
    private GewasType gewas;
    private int jaarOpbrengst;

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

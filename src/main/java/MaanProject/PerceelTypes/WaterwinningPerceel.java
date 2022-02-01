package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;

import java.util.List;
import java.util.Map;

public class WaterwinningPerceel extends Perceel {
    private int jaarOpbrengst;

    public int getJaarOpbrengst() {
        return jaarOpbrengst;
    }

    public WaterwinningPerceel(List<Map<Double, Double>> begrenzing, Inwoner eigenaar, int jaarOpbrengst) {
        super(begrenzing, eigenaar);
        this.jaarOpbrengst = jaarOpbrengst;
    }

    public void setJaarOpbrengst(int jaarOpbrengst) {
        this.jaarOpbrengst = jaarOpbrengst;
    }
}

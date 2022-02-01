package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;

import java.util.List;
import java.util.Map;

public class LanceerBasis extends Perceel {
    private int maximaleRaketGrootte;

    public int getMaximaleRaketGrootte() {
        return maximaleRaketGrootte;
    }

    public void setMaximaleRaketGrootte(int maximaleRaketGrootte) {
        this.maximaleRaketGrootte = maximaleRaketGrootte;
    }

    public LanceerBasis(List<Map<Double, Double>> begrenzing, Inwoner eigenaar, int maximaleRaketGrootte) {
        super(begrenzing, eigenaar);
        this.maximaleRaketGrootte = maximaleRaketGrootte;
    }
}

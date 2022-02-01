package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;

import java.util.List;
import java.util.Map;

public class WoonPerceel extends Perceel {
    private int maxInwoners;
    private List<Inwoner> inwoners;

    public WoonPerceel(List<Map<Double, Double>> begrenzing, Inwoner eigenaar, int maxInwoners, List<Inwoner> inwoners) {
        super(begrenzing, eigenaar);
        this.maxInwoners = maxInwoners;
        this.inwoners = inwoners;
    }

    public WoonPerceel(List<Map<Double, Double>> begrenzing, Inwoner eigenaar, int maxInwoners) {
        super(begrenzing, eigenaar);
        this.maxInwoners = maxInwoners;
    }

    public int getMaxInwoners() {
        return maxInwoners;
    }

    public void setMaxInwoners(int maxInwoners) {
        this.maxInwoners = maxInwoners;
    }

    public List<Inwoner> getInwoners() {
        return inwoners;
    }

    public void intrekkenInwoner(Inwoner inwoner) {
        if(inwoners.size()+1 <= maxInwoners) {
            this.inwoners.add(inwoner);
        }
    }

    public void vertrekkenInwoner(Inwoner inwoner) {
        this.inwoners.remove(inwoner);
    }
}

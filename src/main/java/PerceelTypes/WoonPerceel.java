package src.main.java.PerceelTypes;

import src.main.java.Inwoner;
import src.main.java.Perceel;

import java.util.List;

public class WoonPerceel extends Perceel {
    private int maxInwoners;
    private List<Inwoner> inwoners;

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
        this.inwoners.add(inwoner);
    }

    public void vertrekkenInwoner(Inwoner inwoner) {
        this.inwoners.remove(inwoner);
    }
}

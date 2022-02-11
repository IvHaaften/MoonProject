package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("WOON")
@NoArgsConstructor()
public class WoonPerceel extends Perceel {

    private int maxInwoners;

    @OneToMany
    private List<Inwoner> inwoners;

    public WoonPerceel(Polygon begrenzing, Inwoner eigenaar, int maxInwoners, List<Inwoner> inwoners) {
        super(begrenzing, eigenaar);
        this.maxInwoners = maxInwoners;
        this.inwoners = inwoners;
    }

    public WoonPerceel(Polygon begrenzing, Inwoner eigenaar, int maxInwoners) {
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

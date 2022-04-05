package MaanProject.Models.PerceelTypes;

import MaanProject.Exceptions.MaxInwonerException;
import MaanProject.Models.Inwoner;
import MaanProject.Models.Perceel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.awt.*;
import java.util.List;

@Entity
@DiscriminatorValue("WOON")
@NoArgsConstructor()
@Getter
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

    public void intrekkenInwoner(Inwoner inwoner) throws MaxInwonerException {
        if (inwoners.size() + 1 <= maxInwoners) {
            inwoners.add(inwoner);
        } else {
            throw new MaxInwonerException();
        }
    }

    public void vertrekkenInwoner(Inwoner inwoner) {
        inwoners.remove(inwoner);
    }
}

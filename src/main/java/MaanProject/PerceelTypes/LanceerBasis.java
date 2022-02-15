package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.awt.*;

@Entity
@DiscriminatorValue("LANCEER")
@NoArgsConstructor()
public class LanceerBasis extends Perceel {

    private int maximaleRaketGrootte;

    public int getMaximaleRaketGrootte() {
        return maximaleRaketGrootte;
    }

    public void setMaximaleRaketGrootte(int maximaleRaketGrootte) {
        this.maximaleRaketGrootte = maximaleRaketGrootte;
    }

    public LanceerBasis(Polygon begrenzing, Inwoner eigenaar, int maximaleRaketGrootte) {
        super(begrenzing, eigenaar);
        this.maximaleRaketGrootte = maximaleRaketGrootte;
    }
}

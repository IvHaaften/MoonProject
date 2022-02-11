package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;

import javax.persistence.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("LANCEER")
public class LanceerBasis extends Perceel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

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

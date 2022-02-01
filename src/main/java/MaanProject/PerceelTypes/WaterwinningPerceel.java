package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("WATER")
public class WaterwinningPerceel extends Perceel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

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

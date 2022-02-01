package MaanProject.PerceelTypes;

import MaanProject.Inwoner;
import MaanProject.Perceel;
import MaanProject.constants.GewasType;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("LANDBOUW")
public class LandbouwPerceel extends Perceel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private GewasType gewas;
    private int jaarOpbrengst;

    public LandbouwPerceel(List<Map<Double, Double>> begrenzing, Inwoner eigenaar, GewasType gewas, int jaarOpbrengst) {
        super(begrenzing, eigenaar);
        this.gewas = gewas;
        this.jaarOpbrengst = jaarOpbrengst;
    }

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

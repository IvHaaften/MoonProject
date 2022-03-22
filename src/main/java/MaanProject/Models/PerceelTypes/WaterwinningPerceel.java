package MaanProject.Models.PerceelTypes;

import MaanProject.Models.Inwoner;
import MaanProject.Models.Perceel;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.awt.*;

@Entity
@DiscriminatorValue("WATER")
@NoArgsConstructor()
public class WaterwinningPerceel extends Perceel {

    private int jaarOpbrengst;

    public int getJaarOpbrengst() {
        return jaarOpbrengst;
    }

    public WaterwinningPerceel(Polygon begrenzing, Inwoner eigenaar, int jaarOpbrengst) {
        super(begrenzing, eigenaar);
        this.jaarOpbrengst = jaarOpbrengst;
    }

    public void setJaarOpbrengst(int jaarOpbrengst) {
        this.jaarOpbrengst = jaarOpbrengst;
    }
}

package MaanProject.Models;

import MaanProject.Models.Vervoer.Station;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PERCEELTYPE")
@NoArgsConstructor
@Getter
@ToString
public class Perceel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int oppervlakte;

    private Polygon begrenzing;

    private boolean beperking;

    @ManyToOne
    private Inwoner eigenaar;

    @OneToMany(mappedBy = "perceel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public
    List<Transactie> transacties;

    @OneToMany(mappedBy = "perceel", cascade = CascadeType.ALL)
    List<Station> stations;

    public Perceel(Polygon begrenzing, Inwoner eigenaar) {
        setBegrenzing(begrenzing);
        this.eigenaar = eigenaar;
    }

    @Override
    public String toString() {
        return "Perceel{" +
                "id=" + id +
                ", eigenaar=" + eigenaar +
                '}';
    }

    public void setBegrenzing(Polygon begrenzing) {
        this.begrenzing = begrenzing;
        oppervlakte = 5; //moet berekend worden op basis van de begrenzing
    }

    public void setBeperking(boolean beperking) {
        this.beperking = beperking;
    }

    public void setEigenaar(Inwoner eigenaar) {
        this.eigenaar = eigenaar;
    }

}

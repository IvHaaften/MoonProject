package MaanProject.Vervoer;

import MaanProject.Perceel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "perceel_id")
    private Perceel perceel;

    private String naam;

    public Perceel getPerceel() {
        return perceel;
    }

    public String getNaam() {
        return naam;
    }

    public Station(Perceel perceel, String naam) {
        this.perceel = perceel;
        this.naam = naam;
    }
}

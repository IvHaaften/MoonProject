package MaanProject.Models.Vervoer;

import MaanProject.Models.Perceel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@ToString
public class Station implements Serializable {
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

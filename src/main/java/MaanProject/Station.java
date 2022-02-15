package MaanProject;

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

    /*    private List<Rit> ritten;*/

    public Perceel getPerceel() {
        return perceel;
    }

    public String getNaam() {
        return naam;
    }

/*    public List<Rit> getRitten() {
        return ritten;
    }

    public void ritToevoegen(Rit... ritten) {
        this.ritten.addAll(ritten);
    }*/

    public Station(Perceel perceel, String naam) {
        this.perceel = perceel;
        this.naam = naam;
    }
}

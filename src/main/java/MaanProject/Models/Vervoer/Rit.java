package MaanProject.Models.Vervoer;

import MaanProject.Models.Inwoner;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Entity
@NoArgsConstructor
public class Rit {
    //record ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Vervoersmiddel vervoersmiddel;

    //@OneToMany(mappedBy = "rit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private HashMap<Zitplaats, Inwoner> passagiersLijst;

    @Getter
    //@OneToMany(mappedBy = "rit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CopyOnWriteArrayList<Vracht> vrachtLijst;

    private ZonedDateTime vertrektijd;

    @ManyToOne
    private Station beginStation;
    @ManyToOne
    private Station eindStation;

    public Rit(Vervoersmiddel vervoersmiddel, HashMap<Zitplaats, Inwoner> passagiersLijst, CopyOnWriteArrayList<Vracht> vrachtLijst, ZonedDateTime vertrektijd, Station beginStation, Station eindStation) {
        this.vervoersmiddel = vervoersmiddel;
        this.passagiersLijst = passagiersLijst;
        this.vrachtLijst = vrachtLijst;
        this.vertrektijd = vertrektijd;
        this.beginStation = beginStation;
        this.eindStation = eindStation;
    }

    synchronized public void plaatsVracht(Vracht vracht) {
        if (vrachtLijst.stream()
                .map(Vracht::getFormaat)
                .mapToInt(value -> value.formaat).sum() + vracht.getFormaat().formaat > vervoersmiddel.getVrachtcapaciteit()) {
            throw new RuntimeException("Niet genoeg vrachtcapaciteit over voor deze rit.");
        }
        if (vrachtLijst.size() + 1 > Vervoersmiddel.MAXIMAAL_AANTAL_KRATTEN) {
            throw new RuntimeException("Maximaal aantal kratten voor deze rit is al bereikt.");
        }

        vrachtLijst.add(vracht);
        sorteerVracht();

    }

    public void sorteerVracht() {
        vrachtLijst.sort(Vracht::compareTo);
    }

}

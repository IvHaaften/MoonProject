package MaanProject.Vervoer;

import MaanProject.Inwoner;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.LinkedList;

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

    //@OneToMany(mappedBy = "rit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private LinkedList<Vracht> vrachtLijst;

    private ZonedDateTime vertrektijd;

    @ManyToOne
    private Station beginStation;
    @ManyToOne
    private Station eindStation;

    public Rit(Vervoersmiddel vervoersmiddel, HashMap<Zitplaats, Inwoner> passagiersLijst, LinkedList<Vracht> vrachtLijst, ZonedDateTime vertrektijd, Station beginStation, Station eindStation) {
        this.vervoersmiddel = vervoersmiddel;
        this.passagiersLijst = passagiersLijst;
        this.vrachtLijst = vrachtLijst;
        this.vertrektijd = vertrektijd;
        this.beginStation = beginStation;
        this.eindStation = eindStation;
    }

    public boolean plaatsVracht(Vracht vracht) {
        boolean kanToegevoegdWorden = vrachtLijst.stream().map(Vracht::getFormaat).mapToInt(value -> value.formaat).sum() + vracht.getFormaat().formaat <= vervoersmiddel.getVrachtcapaciteit();
        return kanToegevoegdWorden && (vracht.getBederfelijk() ? vrachtLijst.offerFirst(vracht) : vrachtLijst.offerLast(vracht));
    }

    public void sorteerVracht() {
        vrachtLijst.sort(Vracht::compareTo);
    }

}

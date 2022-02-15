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

    @OneToMany(mappedBy = "rit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private HashMap<Zitplaats, Inwoner> passagiersLijst;

    @OneToMany(mappedBy = "rit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private LinkedList<Vracht> vrachtLijst;

    private ZonedDateTime vertrektijd;
    private Station beginStation;
    private Station eindStation;

    public Rit(HashMap<Zitplaats, Inwoner> passagiersLijst, LinkedList<Vracht> vrachtLijst, ZonedDateTime vertrektijd, Station beginStation, Station eindStation) {
        this.passagiersLijst = passagiersLijst;
        this.vrachtLijst = vrachtLijst;
        this.vertrektijd = vertrektijd;
        this.beginStation = beginStation;
        this.eindStation = eindStation;
    }

    public void plaatVracht(Vracht vracht) {
        boolean plaatsVrachGelukt = vracht.getBederfelijk() ? vrachtLijst.offerFirst(vracht) : vrachtLijst.offerLast(vracht);
    }

    public void sorteerVracht() {
        vrachtLijst.sort(Vracht::compareTo);
    }

}

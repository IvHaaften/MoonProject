package MaanProject.Models.Vervoer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Rit implements Serializable {
    //record ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @ManyToOne
    private Vervoersmiddel vervoersmiddel;

    @OneToMany
    private List<Reservering> reserveringen;

    @Getter
    @OneToMany
    private List<Vracht> vrachtLijst;

    private ZonedDateTime vertrektijd;

    @ManyToOne
    @Getter
    private Station beginStation;
    @ManyToOne
    private Station eindStation;

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

    @Override
    public String toString() {
        return "Rit{" +
                "id=" + id +
                ", vervoersmiddel=" + vervoersmiddel +
//                ", vrachtLijst=" + vrachtLijst +
                ", vertrektijd=" + vertrektijd +
                ", beginStation=" + beginStation +
                ", eindStation=" + eindStation +
                '}';
    }
}

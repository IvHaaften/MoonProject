package MaanProject.Models.Vervoer;

import MaanProject.constants.VervoerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vervoersmiddel implements Serializable {

    public static final int MAXIMAAL_AANTAL_KRATTEN = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private VervoerType type;
    @Getter
    private int vrachtcapaciteit;
    @Getter
    @OneToMany
    private List<Zitplaats> zitplaatsen;
}

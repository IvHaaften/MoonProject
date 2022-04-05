package MaanProject.Models.Vervoer;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@NoArgsConstructor
@ToString
public class Zitplaats {
    //record ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer plaatsNummer;

    public Zitplaats(Integer plaatsNummer, Reservering reservering) {
        this.plaatsNummer = plaatsNummer;
    }
}

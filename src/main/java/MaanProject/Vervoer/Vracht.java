package MaanProject.Vervoer;

import MaanProject.constants.AggregatieToestand;
import MaanProject.constants.KratFormaat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vracht {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private KratFormaat formaat;
    @Getter
    private AggregatieToestand toestand;
    @Getter
    private Boolean bederfelijk;
    @Getter
    private int gewicht;
    @Getter
    private int inhoud;
}

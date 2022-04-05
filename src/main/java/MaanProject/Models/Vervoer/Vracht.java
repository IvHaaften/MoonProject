package MaanProject.Models.Vervoer;

import MaanProject.constants.AggregatieToestand;
import MaanProject.constants.KratFormaat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Vracht implements Comparable<Vracht>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
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

    @Override
    public int compareTo(Vracht vracht) {
        return Boolean.compare(bederfelijk, vracht.bederfelijk);
    }
}

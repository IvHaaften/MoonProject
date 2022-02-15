package MaanProject.Vervoer;

import MaanProject.constants.VervoerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vervoermiddel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private VervoerType type;
    @Getter
    private int vrachtcapaciteit;
    @Getter
    private int passagiercapaciteit;

}

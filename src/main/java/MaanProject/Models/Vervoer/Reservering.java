package MaanProject.Models.Vervoer;

import MaanProject.Models.Inwoner;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Reservering {
    //record ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Rit rit;

    @ManyToOne
    private Inwoner inwoner;

    @ManyToOne
    private Zitplaats zitplaats;

}

package MaanProject.Models.Vervoer;

import MaanProject.constants.VervoerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vervoersmiddel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private VervoerType type;
    @Getter
    private int vrachtcapaciteit;
    @Getter
    private int passagiercapaciteit;

    @Getter
    @OneToMany(mappedBy = "vervoersmiddel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rit> ritten;
}

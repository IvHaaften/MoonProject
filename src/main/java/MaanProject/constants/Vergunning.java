package MaanProject.constants;

import MaanProject.Inwoner;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Getter
@Access(AccessType.FIELD)
public class Vergunning<T extends GenericType> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Inwoner verlener;

    @Transient
    private T type;

    private LocalDate startDatum;
    private LocalDate eindDatum;

    public Vergunning(Inwoner verlener, T type, LocalDate startDatum, LocalDate eindDatum) {
        this.verlener = verlener;
        this.type = type;
        this.startDatum = startDatum;
        this.eindDatum = eindDatum;
    }

}

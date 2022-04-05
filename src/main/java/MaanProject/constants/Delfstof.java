package MaanProject.constants;

import MaanProject.Exceptions.DelfstofException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Builder //hierdoor wordt onder water een DelfstofBuilder aangemaakt door Lombok (vgl getter en setter)
@Entity
@Immutable
@NoArgsConstructor
// @AllArgsConstructor
@ToString
@Getter
public class Delfstof implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String elementnaam;
    private int elementnummer;
    private double stofdichtheid; //in kg/m3
    private boolean radioactief;

    public Delfstof(Integer id, String elementnaam, int elementnummer, double stofdichtheid, boolean radioactief) {
        if (elementnaam == null) {
            throw new DelfstofException();
        }
        this.id = id;
        this.elementnaam = elementnaam;
        this.elementnummer = elementnummer;
        this.stofdichtheid = stofdichtheid;
        this.radioactief = radioactief;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Delfstof delfstof = (Delfstof) o;
        return id != null && Objects.equals(id, delfstof.id);
    }
}

package MaanProject.constants;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder //hierdoor wordt onder water een DelfstofBuilder aangemaakt door Lombok (vgl getter en setter)
@Entity @Immutable
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Delfstof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String elementnaam;
    private int elementnummer;
    private double stofdichtheid; //in kg/m3
    private boolean radioactief;
}

package MaanProject;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;

@Entity
@NoArgsConstructor
public class Inwoner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String getNaam() {
        return naam;
    }

    private String naam;

    private LocalDate geboortedatum;

    @Override
    public String toString() {
        return "Inwoner{" +
                "naam='" + naam + '\'' +
                '}';
    }

    public Inwoner(String naam, LocalDate geboortedatum) {
        this.naam = naam;
        this.geboortedatum = geboortedatum;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public int getLeeftijdInJaren() {
        return Period.between(geboortedatum, LocalDate.now()).getYears();
    }
}

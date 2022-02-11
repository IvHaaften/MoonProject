package MaanProject;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Inwoner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private final LocalDate geboortedatum;

    public Inwoner(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public int getLeeftijdInJaren() {
        return Period.between(geboortedatum, LocalDate.now()).getYears();
    }
}

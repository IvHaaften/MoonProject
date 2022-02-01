package MaanProject;


import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Inwoner {
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

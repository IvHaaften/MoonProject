package MaanProject;

import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactieService extends JpaRepository<Transactie, Integer> {

    @Query("select t from Transaction t where t.datum <= :eindDatum and t.datum => :beginDatum")
    List<Transactie> findByDateRange(@Param("eindDatum")LocalDate eindDatum, @Param("beginDatum")LocalDate beginDatum);


}

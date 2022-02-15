package MaanProject.Service;

import MaanProject.Transactie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactieService extends JpaRepository<Transactie, Integer> {

    @Query("select t from Transactie t where t.datum <= :eindDatum and t.datum >= :beginDatum")
    List<Transactie> findByDateRange(@Param("eindDatum") LocalDate eindDatum, @Param("beginDatum") LocalDate beginDatum);


}

package MaanProject.Service;

import MaanProject.Models.Vervoer.Station;
import MaanProject.Models.Vervoer.Vracht;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StationService extends JpaRepository<Station, Integer> {
}

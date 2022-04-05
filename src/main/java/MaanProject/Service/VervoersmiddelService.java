package MaanProject.Service;

import MaanProject.Models.Vervoer.Rit;
import MaanProject.Models.Vervoer.Vervoersmiddel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VervoersmiddelService extends JpaRepository<Vervoersmiddel, Integer> {
}

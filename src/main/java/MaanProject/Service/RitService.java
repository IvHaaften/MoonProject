package MaanProject.Service;

import MaanProject.Models.Vervoer.Rit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RitService extends JpaRepository<Rit, Integer> {
}

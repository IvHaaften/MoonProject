package MaanProject.Service;

import MaanProject.Models.Vervoer.Rit;
import MaanProject.Models.Vervoer.Vracht;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VrachtService extends JpaRepository<Vracht, Integer> {
}

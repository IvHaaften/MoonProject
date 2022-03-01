package MaanProject.Service;

import MaanProject.Models.Perceel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerceelService extends JpaRepository<Perceel, Integer> {
}

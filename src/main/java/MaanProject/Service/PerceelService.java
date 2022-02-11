package MaanProject.Service;

import MaanProject.Perceel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PerceelService extends JpaRepository<Perceel, Integer> {
}

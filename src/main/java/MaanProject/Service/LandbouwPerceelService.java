package MaanProject.Service;

import MaanProject.Models.PerceelTypes.LandbouwPerceel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandbouwPerceelService extends JpaRepository<LandbouwPerceel, Integer> {
}

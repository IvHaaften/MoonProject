package MaanProject.Service;

import MaanProject.PerceelTypes.LandbouwPerceel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface LandbouwPerceelService extends JpaRepository<LandbouwPerceel, Integer> {
}

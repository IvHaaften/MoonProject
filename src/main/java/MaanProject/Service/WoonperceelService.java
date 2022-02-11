package MaanProject.Service;

import MaanProject.PerceelTypes.WoonPerceel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WoonperceelService extends JpaRepository<WoonPerceel, UUID> {
}

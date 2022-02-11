package MaanProject.Service;

import MaanProject.PerceelTypes.MijnbouwPerceel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface MijnbouwPerceelService extends JpaRepository<MijnbouwPerceel, Integer> {

}

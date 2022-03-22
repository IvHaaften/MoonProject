package MaanProject.Service;

import MaanProject.constants.Delfstof;
import MaanProject.constants.DelfstofType;
import MaanProject.constants.Vergunning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DelfstofVergunningService extends JpaRepository<Vergunning<Delfstof>, Integer> {
}

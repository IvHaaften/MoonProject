package MaanProject.Service;

import MaanProject.constants.GewasType;
import MaanProject.constants.Vergunning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GewasVergunningService extends JpaRepository<Vergunning<GewasType>, Integer> {
}

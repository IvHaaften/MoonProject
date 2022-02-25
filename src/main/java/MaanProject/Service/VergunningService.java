package MaanProject.Service;

import MaanProject.constants.Vergunning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VergunningService extends JpaRepository<Vergunning, Integer> {
}

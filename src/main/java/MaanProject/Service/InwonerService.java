package MaanProject.Service;

import MaanProject.Inwoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface InwonerService extends JpaRepository<Inwoner, Integer> {
}

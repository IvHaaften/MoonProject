package MaanProject.Service;

import MaanProject.Models.Inwoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InwonerService extends JpaRepository<Inwoner, Integer> {
}

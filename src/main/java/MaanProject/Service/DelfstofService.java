package MaanProject.Service;

import MaanProject.constants.Delfstof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelfstofService extends JpaRepository<Delfstof, Integer> {
}



package MaanProject.Service;

import MaanProject.PerceelTypes.WoonPerceel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WoonperceelService extends JpaRepository<WoonPerceel, Integer> {

    @Query("select DISTINCT w from WoonPerceel w JOIN FETCH w.inwoners")
    List<WoonPerceel> findAll();
}

package MaanProject.Service;

import MaanProject.Models.PerceelTypes.WoonPerceel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WoonperceelService extends JpaRepository<WoonPerceel, Integer> {

    @Override
    @Query("select DISTINCT w from WoonPerceel w JOIN FETCH w.inwoners")
    List<WoonPerceel> findAll();
}

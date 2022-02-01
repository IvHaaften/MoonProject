package MaanProject;

import MaanProject.PerceelTypes.PerceelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PerceelService extends JpaRepository<Perceel, UUID> {

    @Query("select p from Perceel p where p.PERCEELTYPE = :perceeltype")
    List<Perceel> findByPerceelType(@Param("perceeltype") PerceelType perceeltype);
}

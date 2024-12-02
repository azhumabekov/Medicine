package java15.repository;

import java15.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Long> {
    List<Medicine> id(Long id);

    @Query("select m from Medicine m where m.name ilike %:name%")
    Medicine searchMedicineByName(@Param("name") String name);

    @Query("select m from Medicine m order by m.name asc")
    List<Medicine> sortByNameForAsc();
    @Query("select m from Medicine m order by m.name desc")
    List<Medicine> sortByNameForDesc();

//    @Query("UPDATE Medicine m SET m.name = :name, m.price = :price WHERE m.id = :id")
//    @Modifying
//    void updateById(@Param("id") Long id, @Param("name") String name, @Param("price") BigDecimal price);
//
//    @Query("update Medicine m set  where m.id = :id")
//    @Modifying
//    void updateById(Long id);
}

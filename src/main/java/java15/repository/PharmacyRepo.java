package java15.repository;

import java15.entity.Medicine;
import java15.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyRepo extends JpaRepository<Pharmacy, Long> {

    @Query("select m from Medicine m join m.pharmacies p where p.id = :id")
    List<Medicine> findMedicinesByPharmacyId(@Param("id") Long id);

    @Query("select p from Pharmacy p join p.workers w where p.id = :id")
    Pharmacy findPharmacyByWorkerId(@Param("id") Long workerId);

    @Query("select p from Pharmacy p where p.name ilike %:name%")
    List<Pharmacy> searchByName(String name);

    @Query("select p from Pharmacy p where size(p.workers) = (select Max(size(p.workers)) from Pharmacy p) ")
    Pharmacy getPharmacyMaxWorkers();
}

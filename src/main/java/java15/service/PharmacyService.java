package java15.service;

import java15.entity.Medicine;
import java15.entity.Pharmacy;

import java.util.List;

public interface PharmacyService {
    Pharmacy save(Pharmacy pharmacy);

    List<Pharmacy> findAll();

    Pharmacy findById(Long id);

    Pharmacy updateById(Long id, Pharmacy NewPharmacy);

    void deleteById(Long id);


    List<Medicine> findMedicinesByPharmacyId(Long id);

    Pharmacy findPharmacyByWorkerId(Long workerId);

    List<Pharmacy> searchByName(String name);

    Pharmacy getPharmacyMaxWorkers();


}

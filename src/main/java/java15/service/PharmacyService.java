package java15.service;

import java15.entity.Medicine;
import java15.entity.Pharmacy;

import java.util.List;

public interface PharmacyService {
    void save(Pharmacy pharmacy);

    List<Pharmacy> findAll();

    Pharmacy findById(Long id);

    void updateById(Long id, Pharmacy NewPharmacy);

    void deleteById(Long id);


}

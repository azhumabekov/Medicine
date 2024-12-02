package java15.service;

import java15.entity.Medicine;

import java.util.List;

public interface MedicineService {


    void save(Medicine medicine);

    List<Medicine> findAll();

    Medicine findById(Long id);

    void updateById(Long id, Medicine NewMedicine);

    void deleteById(Long id);

    List<Medicine> sortByName(String asc, String desc);

    Medicine searchByName(String name);
}

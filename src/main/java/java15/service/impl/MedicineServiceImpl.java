package java15.service.impl;

import java15.entity.Medicine;
import java15.repository.MedicineRepo;
import java15.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {
    private final MedicineRepo medicineRepo;

    @Override
    public void save(Medicine medicine) {
        medicineRepo.save(medicine);
    }
    @Override
    public List<Medicine> findAll() {
        return medicineRepo.findAll();
    }

    @Override
    public Medicine findById(Long id) {
        return medicineRepo.findById(id).get();
    }

    @Override
    public void updateById(Long id, Medicine NewMedicine) {

        Medicine medicine = medicineRepo.findById(id).get();
        medicine.setPrice(NewMedicine.getPrice());
        medicine.setName(NewMedicine.getName());
        medicineRepo.save(medicine);
    }

    @Override
    public void deleteById(Long id) {
        medicineRepo.deleteById(id);
    }

    @Override
    public List<Medicine> sortByName(String sortDirection) {
        if (sortDirection.equals("asc")) {
            return medicineRepo.sortByNameForAsc();
        }
        return medicineRepo.sortByNameForDesc();
    }
    @Override
    public Medicine searchByName(String name) {
        return medicineRepo.searchMedicineByName(name);
    }


}

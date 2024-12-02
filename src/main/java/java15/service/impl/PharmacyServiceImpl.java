package java15.service.impl;

import java15.entity.Medicine;
import java15.entity.Pharmacy;
import java15.repository.PharmacyRepo;
import java15.service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService {
    private final PharmacyRepo pharmacyRepo;

    @Override
    public Pharmacy save(Pharmacy pharmacy) {
        pharmacyRepo.save(pharmacy);
        return pharmacy;
    }

    @Override
    public List<Pharmacy> findAll() {
        return pharmacyRepo.findAll();
    }

    @Override
    public Pharmacy findById(Long id) {
        return pharmacyRepo.findById(id).get();
    }

    @Override
    public Pharmacy updateById(Long id, Pharmacy NewPharmacy) {
        Pharmacy pharmacy = pharmacyRepo.findById(id).get();
        pharmacy.setName(NewPharmacy.getName());
        pharmacy.setAddress(NewPharmacy.getAddress());
        pharmacyRepo.save(pharmacy);

        return pharmacy;
    }

    @Override
    public void deleteById(Long id) {
        pharmacyRepo.deleteById(id);
    }

    @Override
    public List<Medicine> findMedicinesByPharmacyId(Long id) {
        return pharmacyRepo.findMedicinesByPharmacyId(id);
    }

    @Override
    public Pharmacy findPharmacyByWorkerId(Long workerId) {
        return pharmacyRepo.findPharmacyByWorkerId(workerId);
    }

    @Override
    public List<Pharmacy> searchByName(String name) {
        return pharmacyRepo.searchByName(name);
    }

    @Override
    public Pharmacy getPharmacyMaxWorkers() {
        return pharmacyRepo.getPharmacyMaxWorkers();
    }


}

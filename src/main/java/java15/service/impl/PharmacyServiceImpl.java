package java15.service.impl;

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
    public void save(Pharmacy pharmacy) {
        pharmacyRepo.save(pharmacy);
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
    public void updateById(Long id, Pharmacy NewPharmacy) {
        Pharmacy pharmacy = pharmacyRepo.findById(id).get();
        pharmacy.setName(NewPharmacy.getName());
        pharmacy.setAddress(NewPharmacy.getAddress());
        pharmacyRepo.save(pharmacy);

    }

    @Override
    public void deleteById(Long id) {
        pharmacyRepo.deleteById(id);
    }
}

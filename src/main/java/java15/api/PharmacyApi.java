package java15.api;

import java15.entity.Medicine;
import java15.entity.Pharmacy;
import java15.service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacies")
@RequiredArgsConstructor
public class PharmacyApi {
    private final PharmacyService pharmacyService;
    // 1. Save a pharmacy
    @PostMapping("/save")
    public Pharmacy savePharmacy(@RequestBody Pharmacy pharmacy) {
        return pharmacyService.save(pharmacy);
    }

    // 2. Get all pharmacies
    @GetMapping
    public List<Pharmacy> getAllPharmacies() {
        return pharmacyService.findAll();
    }

    // 3. Get a pharmacy by ID
    @GetMapping("/{id}")
    public Pharmacy getPharmacyById(@PathVariable Long id) {
        return pharmacyService.findById(id);
    }

    // 4. Update a pharmacy by ID
    @PutMapping("/update/{id}")
    public Pharmacy updatePharmacy(@PathVariable Long id, @RequestBody Pharmacy newPharmacy) {
        return pharmacyService.updateById(id, newPharmacy);
    }

    // 5. Delete a pharmacy by ID
    @DeleteMapping("/delete/{id}")
    public void deletePharmacy(@PathVariable Long id) {
        pharmacyService.deleteById(id);
    }

    // 6. Get all medicines by pharmacy ID
    @GetMapping("/{id}/medicines")
    public List<Medicine> getMedicinesByPharmacyId(@PathVariable Long id) {
        return pharmacyService.findMedicinesByPharmacyId(id);
    }

    // 7. Find a pharmacy by worker ID
    @GetMapping("/worker/{workerId}")
    public Pharmacy getPharmacyByWorkerId(@PathVariable Long workerId) {
        return pharmacyService.findPharmacyByWorkerId(workerId);
    }

    // 8. Search pharmacies by name
    @GetMapping("/search")
    public List<Pharmacy> searchPharmaciesByName(@RequestParam String name) {
        return pharmacyService.searchByName(name);
    }

    // 9. Get the pharmacy with the maximum workers
    @GetMapping("/max-workers")
    public Pharmacy getPharmacyWithMaxWorkers() {
        return pharmacyService.getPharmacyMaxWorkers();
    }

}

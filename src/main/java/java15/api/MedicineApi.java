package java15.api;

import java15.entity.Medicine;
import java15.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
@RequiredArgsConstructor
public class MedicineApi {
    private final MedicineService medicineService;

    @GetMapping
    public List<Medicine> getMedicines() {
        return medicineService.findAll();
    }

    @PutMapping
    public Medicine addMedicine(@RequestBody Medicine medicine) {
            medicineService.save(medicine);
            return medicine;
    }

    @DeleteMapping
    public void deleteMedicine(@RequestBody Medicine medicine) {
        medicineService.deleteById(medicine.getId());
    }

    @PutMapping("/update")
    public Medicine updateMedicine(@RequestBody Medicine medicine) {
        medicineService.save(medicine);
        return medicine;
    }



}

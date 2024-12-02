package java15.api;

import java15.entity.Worker;
import java15.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkerApi {
    private final WorkerService workerService;

    // Save a worker
    @PostMapping("/save")
    public void saveWorker(@RequestBody Worker worker) {
        workerService.save(worker);
    }

    // Get all workers
    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerService.findAll();
    }

    // Get a worker by ID
    @GetMapping("/{id}")
    public Worker getWorkerById(@PathVariable Long id) {
        return workerService.findById(id);
    }

    // Update a worker by ID
    @PutMapping("/update/{id}")
    public void updateWorkerById(@PathVariable Long id, @RequestBody Worker newWorker) {
        workerService.updateById(id, newWorker);
    }

    // Delete a worker by ID
    @DeleteMapping("/delete/{id}")
    public void deleteWorkerById(@PathVariable Long id) {
        workerService.deleteById(id);
    }

    // Get all workers sorted
    @GetMapping("/sort")
    public List<Worker> getAllSorted(
            @RequestParam String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return workerService.getAllSorted(sortBy, direction);
    }

    // Get the average age of workers
    @GetMapping("/average-age")
    public Double getAverageAge() {
        return workerService.getAverageAge();
    }


//    @GetMapping("/average-age")
//    public ResponseEntity<Double> getAverageAge() {
//        return ResponseEntity.ok(workerService.getAverageAge());
//    }


}

package java15.service.impl;

import java15.entity.Worker;
import java15.repository.WorkerRepo;
import java15.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepo workerRepo;
    @Override
    public void save(Worker worker) {
        workerRepo.save(worker);
    }

    @Override
    public List<Worker> findAll() {
        return workerRepo.findAll();
    }

    @Override
    public Worker findById(Long id) {
        return workerRepo.findById(id).get();
    }

    @Override
    public void updateById(Long id, Worker NewWorker) {
        Worker worker = workerRepo.findById(id).get();
        worker.setName(NewWorker.getName());
        worker.setSalary(NewWorker.getSalary());
        worker.setEmail(NewWorker.getEmail());
        worker.setAddress(NewWorker.getAddress());
        worker.setDateOfBirth(NewWorker.getDateOfBirth());

        workerRepo.save(worker);

    }

    @Override
    public void deleteById(Long id) {
        workerRepo.deleteById(id);
    }

    @Override
    public List<Worker> getAllSorted(String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        return workerRepo.findAll(sort);
    }



    @Override
    public Double getAverageAge() {
        List<LocalDate> birthDates = workerRepo.findAllBirthDates();

        // Преобразуем даты рождения в возраст
        List<Integer> ages = birthDates.stream()
                .map(dateOfBirth -> Period.between(dateOfBirth, LocalDate.now()).getYears())
                .collect(Collectors.toList());

        // Рассчитываем средний возраст
        return ages.stream()
                .mapToInt(age -> age)
                .average()
                .orElse(0.0);
    }

}

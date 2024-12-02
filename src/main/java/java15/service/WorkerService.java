package java15.service;

import java15.entity.Worker;

import java.util.List;
import java.util.Set;

public interface WorkerService {
    void save(Worker worker);

    List<Worker> findAll();

    Worker findById(Long id);

    void updateById(Long id, Worker NewWorker);

    void deleteById(Long id);


    List<Worker> getAllSorted(String sortBy, String direction);

    Double getAverageAge();
}

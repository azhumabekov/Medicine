package java15.repository;

import java15.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long> {
    @Query("select w.dateOfBirth from Worker w")
    List<LocalDate> findAllBirthDates();
}

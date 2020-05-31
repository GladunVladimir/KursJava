package spbstu.valdemar.four.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.valdemar.four.domain.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {
}

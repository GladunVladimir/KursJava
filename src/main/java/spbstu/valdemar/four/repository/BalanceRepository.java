package spbstu.valdemar.four.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.valdemar.four.domain.Balance;

@Repository
public interface BalanceRepository extends CrudRepository<Balance, Long> {
}

package spbstu.valdemar.four.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.valdemar.four.domain.Balance;
import spbstu.valdemar.four.repository.BalanceRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/balance")
public class BalanceController {
  private final BalanceRepository balanceRepository;

  @GetMapping
  @PreAuthorize("isAuthenticated()")
  public List<Balance> getAll() {
    return StreamSupport
        .stream(balanceRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @GetMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Balance getOne(@PathVariable("id") Balance balance) {
    return balance;
  }

  @PostMapping
  @PreAuthorize("isAuthenticated()")
  public Balance saveOne(@RequestBody Balance balance) {
    return balanceRepository.save(balance);
  }

  @PutMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Balance updateOne(@PathVariable("id") Balance balanceFromDb, @RequestBody Balance updatedBalance) {
    BeanUtils.copyProperties(updatedBalance, balanceFromDb, "id");

    return balanceRepository.save(balanceFromDb);
  }

  @DeleteMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Balance balance) {
    balanceRepository.delete(balance);
  }
}

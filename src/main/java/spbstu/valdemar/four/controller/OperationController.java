package spbstu.valdemar.four.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.valdemar.four.domain.Operation;
import spbstu.valdemar.four.repository.OperationRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/operation")
@RequiredArgsConstructor
public class OperationController {
  private final OperationRepository operationRepository;

  @GetMapping
  @PreAuthorize("isAuthenticated()")
  public List<Operation> getAll() {
    return StreamSupport
        .stream(operationRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @GetMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Operation getOne(@PathVariable("id") Operation operation) {
    return operation;
  }

  @PostMapping
  public Operation saveOne(@RequestBody Operation operation) {
    return operationRepository.save(operation);
  }

  @PutMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Operation updateOne(@PathVariable("id") Operation operationFromDb, @RequestBody Operation updatedOperation) {
    BeanUtils.copyProperties(updatedOperation, operationFromDb, "id");

    return operationRepository.save(operationFromDb);
  }

  @DeleteMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Operation operation) {
    operationRepository.delete(operation);
  }
}

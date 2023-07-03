package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.model.Departamento;
import pe.todotic.bookstoreapi_s2.repository.DepartamentoRepository;


import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {
  @Autowired
  private DepartamentoRepository departamentoRepository;
  @GetMapping("/list")
  List<Departamento> list() {
    return departamentoRepository.findAll();
  }
  @GetMapping("/{id}")
  Departamento get(@PathVariable String id) {
    return departamentoRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
  }
}

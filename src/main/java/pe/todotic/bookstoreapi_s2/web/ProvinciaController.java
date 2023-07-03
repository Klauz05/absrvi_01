package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.todotic.bookstoreapi_s2.model.Departamento;
import pe.todotic.bookstoreapi_s2.model.Provincia;
import pe.todotic.bookstoreapi_s2.repository.ProvinciaRepository;

import java.util.List;

@RestController
@RequestMapping("api/provincias")
public class ProvinciaController {
  @Autowired
  private ProvinciaRepository provinciaRepository;

  @GetMapping("/list")
    List<Provincia> list(){
    return provinciaRepository.findAll();
    }
  @GetMapping("/{id}")
  Provincia get(@PathVariable String id) {
    return provinciaRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
  }
  @GetMapping("/list/{iddepartamento}")
  List<Provincia> listProvincia(@PathVariable String iddepartamento) {
    return provinciaRepository.findAllByIdDepartamento(iddepartamento);
  }
}

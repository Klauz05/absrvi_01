package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.todotic.bookstoreapi_s2.model.Distrito;
import pe.todotic.bookstoreapi_s2.repository.DistritoRepository;

import java.util.List;

@RestController
@RequestMapping("api/distritos")
public class DistritoController {
  @Autowired
  private DistritoRepository distritoRepository;

  @GetMapping("/list")
  List<Distrito> list() {
    return distritoRepository.findAll();
  }

  @GetMapping("{id}")
  Distrito get(@PathVariable String id) {
    return distritoRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
  }
  @GetMapping("/list/{idprovincia}")
  List<Distrito> listDistrito(@PathVariable String idprovincia) {
    return distritoRepository.findAllByIdprovincia(idprovincia);
  }
}

package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.todotic.bookstoreapi_s2.model.Detperser;
import pe.todotic.bookstoreapi_s2.model.Detrecser;
import pe.todotic.bookstoreapi_s2.model.Maerec;
import pe.todotic.bookstoreapi_s2.repository.MaerecRepository;

import java.util.List;

@RestController
@RequestMapping("/api/maerec")
@AllArgsConstructor
public class MaerecController {
  private MaerecRepository maerecRepository;
  @GetMapping("/list")
  List<Maerec> get() {
    return maerecRepository.findAll();
  }
  @GetMapping("/{id}")
  Maerec get(@PathVariable Integer id) {
    return maerecRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}

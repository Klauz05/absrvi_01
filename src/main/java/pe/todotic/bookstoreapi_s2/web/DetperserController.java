package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.exception.BadRequestException;
import pe.todotic.bookstoreapi_s2.model.Book;
import pe.todotic.bookstoreapi_s2.model.Detperser;
import pe.todotic.bookstoreapi_s2.model.Maeordser;
import pe.todotic.bookstoreapi_s2.model.User;
import pe.todotic.bookstoreapi_s2.repository.DetperserRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/detperser")
public class DetperserController {
  private DetperserRepository detperserRepository;

  @GetMapping("/list")
    List<Detperser> getAll() {
      return detperserRepository.findAll();
    }
  @GetMapping("/{id}")
  Detperser get(@PathVariable Integer id) {
    return detperserRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
  @GetMapping("/idOrd:{id}")
  List<Detperser> getByOrderSer(@PathVariable Integer id) {
    return detperserRepository.findByMaeordser_IdAndEstDetPerSer(id, 1);
  }
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Detperser create(@RequestBody Detperser detperser) {
    detperser.setEstDetPerSer(1);
    detperser.setEstPagPer(1);
    detperser.setFecRegDetPer(LocalDateTime.now());
    return detperserRepository.save(detperser);
  }
  @PutMapping("/{id}")
  Detperser update(
    @PathVariable Integer id,
    @RequestBody @Validated Detperser form
  ) {
    Detperser detperser = detperserRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
    detperser.setDetSerPer(form.getDetSerPer());
    detperser.setUser(form.getUser());
    detperser.setFecPerAteSer(form.getFecPerAteSer());
    detperser.setHorEntPer(form.getHorEntPer());
    detperser.setHorSalPer(form.getHorSalPer());
    detperser.setFecRegModPer(LocalDateTime.now());
    return detperserRepository.save(detperser);
  }
  @PutMapping("/eliminar/{id}")
  Detperser updateeliminar(
    @PathVariable Integer id,
    @RequestBody @Validated Detperser form
  ) {
    Detperser detperser = detperserRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
    detperser.setEstDetPerSer(2);
    detperser.setFecRegModPer(LocalDateTime.now());
    return detperserRepository.save(detperser);
  }
}

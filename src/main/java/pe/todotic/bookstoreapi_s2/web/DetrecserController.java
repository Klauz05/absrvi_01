package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.model.Detperser;
import pe.todotic.bookstoreapi_s2.model.Detrecser;
import pe.todotic.bookstoreapi_s2.repository.DetrecserRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/detrecser")
@AllArgsConstructor
public class DetrecserController {
  private DetrecserRepository detrecserRepository;
  @GetMapping("/{id}")
  Detrecser get(@PathVariable Integer id) {
    return detrecserRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
  @GetMapping("/idOrd:{id}")
  List<Detrecser> getByOrderSer(@PathVariable Integer id) {
    return detrecserRepository.findByMaeordser_IdAndEstDetRecSer(id, 1);
  }
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Detrecser create(@RequestBody Detrecser detrecser) {
    detrecser.setEstDetRecSer(1);
    detrecser.setFecReg(LocalDateTime.now());
    return detrecserRepository.save(detrecser);
  }
  @PutMapping("/{id}")
  Detrecser update(
    @PathVariable Integer id,
    @RequestBody @Validated Detrecser form
  ) {
    Detrecser detrecser = detrecserRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
    detrecser.setObsRecSer(form.getObsRecSer());
    detrecser.setMaerec(form.getMaerec());
    detrecser.setFecMod(LocalDateTime.now());
    detrecser.setCanRecSer(form.getCanRecSer());
    return detrecserRepository.save(detrecser);
  }
  @PutMapping("/eliminar/{id}")
  Detrecser updateeliminar(
    @PathVariable Integer id,
    @RequestBody @Validated Detrecser form
  ) {
    Detrecser detrecser = detrecserRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
    detrecser.setEstDetRecSer(2);
    detrecser.setFecMod(LocalDateTime.now());
    return detrecserRepository.save(detrecser);
  }
}

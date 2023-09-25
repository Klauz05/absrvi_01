package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.model.Detperser;
import pe.todotic.bookstoreapi_s2.model.Detpreordser;
import pe.todotic.bookstoreapi_s2.repository.DetperserRepository;
import pe.todotic.bookstoreapi_s2.repository.DetpreordserRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/detpreordser")
public class DetpreordserController {
  private DetpreordserRepository detpreordserRepository;
  @GetMapping("/{id}")
  Detpreordser get(@PathVariable Integer id) {
    return detpreordserRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
  @GetMapping("/idOrd:{id}")
  List<Detpreordser> getByOrderSer(@PathVariable Integer id) {
    return detpreordserRepository.findByMaeordser_IdAndEstado(id, "ACTIVO");
  }
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Detpreordser create(@RequestBody Detpreordser detpreordser) {
    detpreordser.setEstado(Detpreordser.Estado.ACTIVO);
    detpreordser.setFecReg(LocalDateTime.now());
    return detpreordserRepository.save(detpreordser);
  }
  @PutMapping("/{id}")
  Detpreordser update(
    @PathVariable Integer id,
    @RequestBody @Validated Detpreordser form
  ) {
    Detpreordser detpreordser = detpreordserRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
    detpreordser.setObsDetPre(form.getObsDetPre());
    detpreordser.setMaerec(form.getMaerec());
    detpreordser.setCanRecPre(form.getCanRecPre());
    detpreordser.setValRecPre(form.getValRecPre());
    detpreordser.setIdUsuMod(form.getIdUsuMod());
    detpreordser.setFecMod(LocalDateTime.now());
    return detpreordserRepository.save(detpreordser);
  }
  @PutMapping("/eliminar/{id}")
  Detpreordser updateeliminar(
    @PathVariable Integer id,
    @RequestBody @Validated Detpreordser form
  ) {
    Detpreordser detpreordser = detpreordserRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
    detpreordser.setEstado(Detpreordser.Estado.INACTIVO);
    detpreordser.setIdUsuMod(form.getIdUsuMod());
    detpreordser.setFecMod(LocalDateTime.now());
    return detpreordserRepository.save(detpreordser);
  }
}

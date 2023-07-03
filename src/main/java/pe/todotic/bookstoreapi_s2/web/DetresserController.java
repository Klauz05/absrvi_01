package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.model.Book;
import pe.todotic.bookstoreapi_s2.model.Detrecser;
import pe.todotic.bookstoreapi_s2.model.Detresser;
import pe.todotic.bookstoreapi_s2.model.Maeordser;
import pe.todotic.bookstoreapi_s2.repository.DetresserRepository;
import pe.todotic.bookstoreapi_s2.repository.MaeordserRepository;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/detresser")
@AllArgsConstructor
public class DetresserController {
  private DetresserRepository detresserRepository;
  private MaeordserRepository maeordserRepository;

  @GetMapping("/{id}")
  Detresser get(@PathVariable Integer id) {
    return detresserRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
  @GetMapping("/idOrd:{id}")
  Detresser getByOrderSer(@PathVariable Integer id) {
    return detresserRepository.findOneByMaeordser_Id(id).orElseThrow(EntityNotFoundException::new);
  }
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Detresser create(@RequestBody Detresser detresser) {
    Maeordser maeordser = maeordserRepository.findById(detresser.getMaeordser().getId())
      .orElseThrow(EntityNotFoundException::new);
    maeordser.setEstAteSer(3);
    maeordser.setFecModReg(LocalDateTime.now());
    maeordserRepository.save(maeordser);
    detresser.setFecRegRes(LocalDateTime.now());
    return detresserRepository.save(detresser);
  }
}

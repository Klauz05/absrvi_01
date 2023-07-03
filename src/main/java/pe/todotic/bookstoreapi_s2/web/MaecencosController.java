package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.model.Cliente;
import pe.todotic.bookstoreapi_s2.model.Maecencos;
import pe.todotic.bookstoreapi_s2.repository.MaecencosRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/maecencos")
public class MaecencosController {
  @Autowired
  private MaecencosRepository maecencosRepository;

  @GetMapping("/list")
  List<Maecencos> list(){
    return maecencosRepository.findAll();
  }

  @GetMapping("{id}")
    Maecencos get(@PathVariable Integer id){
    return maecencosRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
    }
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Maecencos create(@RequestBody Maecencos maecencos) {
    maecencos.setFecRegCenCos(LocalDateTime.now());
    return maecencosRepository.save(maecencos);
  }
  @PutMapping("/{id}")
  Maecencos update(
    @PathVariable Integer id,
    @RequestBody Maecencos form
  ) {
    Maecencos maecencos = maecencosRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
    maecencos.setDesCenCos(form.getDesCenCos());

    return maecencosRepository.save(maecencos);
  }
}

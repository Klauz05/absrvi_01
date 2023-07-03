package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.model.Maecencos;
import pe.todotic.bookstoreapi_s2.model.Maeconcli;
import pe.todotic.bookstoreapi_s2.repository.MaeconcliRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/maeconcli")
public class MaeconcliController {
  @Autowired
  private MaeconcliRepository maeconcliRepository;

  @GetMapping("/list")
  List<Maeconcli> list(){
    return maeconcliRepository.findAll();
  }
  @GetMapping("{id}")
  Maeconcli get(@PathVariable Integer id){
    return maeconcliRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
  }
  @GetMapping("/cliente/{id}")
  List<Maeconcli> getByCliente(@PathVariable Integer id){
    return maeconcliRepository.findByCliente_Id(id);
  }
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Maeconcli create(@RequestBody Maeconcli maeconcli) {
    maeconcli.setFecRegConCli(LocalDateTime.now());
    return maeconcliRepository.save(maeconcli);
  }
  @PutMapping("/{id}")
  Maeconcli update(
    @PathVariable Integer id,
    @RequestBody Maeconcli form
  ) {
    Maeconcli maeconcli = maeconcliRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
    maeconcli.setNomConCli(form.getNomConCli());
    maeconcli.setEmailConCli(form.getEmailConCli());
    maeconcli.setCarConCli(form.getCarConCli());
    maeconcli.setCliente(form.getCliente());
    maeconcli.setDirConCli(form.getDirConCli());

    return maeconcliRepository.save(maeconcli);
  }
}

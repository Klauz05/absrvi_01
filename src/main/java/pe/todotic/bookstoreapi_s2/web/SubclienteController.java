package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.model.Cliente;
import pe.todotic.bookstoreapi_s2.model.Subcliente;
import pe.todotic.bookstoreapi_s2.repository.ClienteRepository;
import pe.todotic.bookstoreapi_s2.repository.SubclienteRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/subclientes")
public class SubclienteController {
  @Autowired
  private SubclienteRepository subclienteRepository;

  @GetMapping("/list")
  List<Subcliente> list() {
    return subclienteRepository.findAll();
  }
  @GetMapping("/{id}")
  Subcliente get(@PathVariable Integer id) {
    return subclienteRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
  }
  @GetMapping("/cliente/{id}")
 List<Subcliente> getByCliente(@PathVariable Integer id) {
    return subclienteRepository.findByCliente_Id(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Subcliente create(@RequestBody Subcliente subcliente) {
    subcliente.setFecRegCli(LocalDateTime.now());
    return subclienteRepository.save(subcliente);
  }
  @PutMapping("/{id}")
  Subcliente update(
    @PathVariable Integer id,
    @RequestBody Subcliente form
  ) {
    Subcliente subcliente = subclienteRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);

    subcliente.setDesSubCli(form.getDesSubCli());
    subcliente.setCliente(form.getCliente());
    return subclienteRepository.save(subcliente);
  }
}

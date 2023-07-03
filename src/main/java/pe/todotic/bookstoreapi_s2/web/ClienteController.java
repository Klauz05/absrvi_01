package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.model.Cliente;
import pe.todotic.bookstoreapi_s2.repository.ClienteRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping("/list")
  List<Cliente> list() {
    return clienteRepository.findAll();
  }
  @GetMapping("/{id}")
  Cliente get(@PathVariable Integer id) {
    return clienteRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
  }
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Cliente create(@RequestBody Cliente cliente) {
    cliente.setFecRegCli(LocalDateTime.now());
    return clienteRepository.save(cliente);
  }
  @PutMapping("/{id}")
  Cliente update(
    @PathVariable Integer id,
    @RequestBody Cliente form
  ) {
    Cliente cliente = clienteRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);

    cliente.setRazSocCli(form.getRazSocCli());
    cliente.setNomComCli(form.getNomComCli());
    cliente.setDirPriCli(form.getDirPriCli());
    cliente.setMaetipdoc(form.getMaetipdoc());
    cliente.setFecModCli(LocalDateTime.now());

    return clienteRepository.save(cliente);
  }

}

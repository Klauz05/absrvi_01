package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.model.Proyecto;
import pe.todotic.bookstoreapi_s2.model.Subcliente;
import pe.todotic.bookstoreapi_s2.repository.ProyectoRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {
  @Autowired
  private ProyectoRepository proyectoRepository;
  @GetMapping("/list")
  List<Proyecto> list() {
    return proyectoRepository.findAll();
  }
  @GetMapping("/{id}")
  Proyecto get(@PathVariable Integer id) {
    return proyectoRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
  }
  @GetMapping("/subcliente/{id}")
  List<Proyecto> getSubCliente(@PathVariable Integer id) {
    return proyectoRepository.findBySubcliente_Id(id);
  }
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Proyecto create(@RequestBody Proyecto proyecto) {
    proyecto.setFecRegPro(LocalDateTime.now());
    return proyectoRepository.save(proyecto);
  }
  @PutMapping("/{id}")
  Proyecto update(
    @PathVariable Integer id,
    @RequestBody Proyecto form
  ) {
    Proyecto proyecto = proyectoRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);

    proyecto.setDesProy(form.getDesProy());
    proyecto.setSubcliente(form.getSubcliente());
    return proyectoRepository.save(proyecto);
  }

}

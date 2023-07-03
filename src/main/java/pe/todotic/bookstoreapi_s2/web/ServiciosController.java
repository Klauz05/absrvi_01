package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.exception.BadRequestException;
import pe.todotic.bookstoreapi_s2.model.Book;
import pe.todotic.bookstoreapi_s2.model.Servicios;
import pe.todotic.bookstoreapi_s2.repository.ServiciosRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/tipo-servicios")
public class ServiciosController {
  @Autowired
  private ServiciosRepository serviciosRepository;

  @GetMapping("/list")
  List<Servicios> list(){
    return serviciosRepository.findAll();
  }
  @GetMapping("{id}")
  Servicios get(@PathVariable Integer id){
    return serviciosRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
  }
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Servicios created(@RequestBody Servicios servicios){
    servicios.setFecRegSer(LocalDateTime.now());
    return serviciosRepository.save(servicios);
  }
  @PutMapping("/{id}")
  Servicios update(
    @PathVariable Integer id,
    @RequestBody @Validated Servicios form
  ) {
    Servicios servicios = serviciosRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);

    servicios.setDesSer(form.getDesSer());

    return serviciosRepository.save(servicios);
  }
}

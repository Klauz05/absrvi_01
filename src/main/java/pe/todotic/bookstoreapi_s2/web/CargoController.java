package pe.todotic.bookstoreapi_s2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.exception.BadRequestException;
import pe.todotic.bookstoreapi_s2.model.Book;
import pe.todotic.bookstoreapi_s2.model.Cargo;
import pe.todotic.bookstoreapi_s2.repository.CargoRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {
  @Autowired
  private CargoRepository cargoRepository;
  @GetMapping("/list")
  List<Cargo> list() {
    return cargoRepository.findAll();
  }
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Cargo create(@RequestBody @Validated Cargo cargo) {

    cargo.setFecregcar(LocalDateTime.now());
    return cargoRepository.save(cargo);
  }

}

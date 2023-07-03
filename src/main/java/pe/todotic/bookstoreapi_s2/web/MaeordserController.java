package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.exception.BadRequestException;
import pe.todotic.bookstoreapi_s2.model.Book;
import pe.todotic.bookstoreapi_s2.model.Maeordser;
import pe.todotic.bookstoreapi_s2.repository.MaeordserRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/maeordser")
@AllArgsConstructor
public class MaeordserController {
  private MaeordserRepository maeordserRepository;

  @GetMapping("/list")
  List<Maeordser> list() {
    return maeordserRepository.findAll();
  }

  @GetMapping("/{id}")
  Maeordser get(@PathVariable Integer id) {
    return maeordserRepository.findById(id).
      orElseThrow(EntityNotFoundException::new);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  Maeordser create(@RequestBody @Validated Maeordser maeordser) {
    maeordser.setEstAteSer(1);
    maeordser.setFecRegSer(LocalDateTime.now());
    return maeordserRepository.save(maeordser);
  }

  @PutMapping("/{id}")
  Maeordser update(
    @PathVariable Integer id,
    @RequestBody @Validated Maeordser form
  ) {
    Maeordser maeordser = maeordserRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);

    maeordser.setCliente(form.getCliente());
    maeordser.setSubcliente(form.getSubcliente());
    maeordser.setProyecto(form.getProyecto());
    maeordser.setMaeconcli(form.getMaeconcli());
    maeordser.setIdCenCos(form.getIdCenCos());
    maeordser.setServicios(form.getServicios());
    maeordser.setTurSer(form.getTurSer());
    maeordser.setUniMedSer(form.getUniMedSer());
    maeordser.setCanSer(form.getCanSer());
    maeordser.setFreSer(form.getFreSer());
    maeordser.setCanDiaFreSer(form.getCanDiaFreSer());
    maeordser.setCoordinador(form.getCoordinador());
    maeordser.setOriVenSer(form.getOriVenSer());
    maeordser.setNumOriVenSer(form.getNumOriVenSer());
    maeordser.setUniMedSer(form.getUniMedSer());
    maeordser.setIdDep(form.getIdDep());
    maeordser.setIdProDep(form.getIdProDep());
    maeordser.setIdDisProDep(form.getIdDisProDep());
    maeordser.setDirSer(form.getDirSer());
    maeordser.setDesSer(form.getDesSer());
    maeordser.setConSer(form.getConSer());
    maeordser.setUniMedSer(form.getUniMedSer());
    maeordser.setVendedor(form.getVendedor());
    maeordser.setFecIniSer(form.getFecIniSer());
    maeordser.setFecFinSer(form.getFecFinSer());
    maeordser.setFecModReg(LocalDateTime.now());

    return maeordserRepository.save(maeordser);
  }
  @PutMapping("/valor/{id}")
  Maeordser updateValor(
    @PathVariable Integer id,
    @RequestBody @Validated Maeordser form
  ) {
    Maeordser maeordser = maeordserRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
    maeordser.setEstConSer(2);
maeordser.setValSer(form.getValSer());
    maeordser.setFecModReg(LocalDateTime.now());

    return maeordserRepository.save(maeordser);
  }
}

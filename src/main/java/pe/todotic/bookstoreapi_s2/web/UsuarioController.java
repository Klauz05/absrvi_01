package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.config.WebSecurityConfig;
import pe.todotic.bookstoreapi_s2.exception.BadRequestException;
import pe.todotic.bookstoreapi_s2.model.User;
import pe.todotic.bookstoreapi_s2.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UsuarioController {
  private UserRepository userRepository;
private PasswordEncoder passwordEncoder;
  @GetMapping("/list")
  List<User> list() {
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  User get(@PathVariable Integer id) {
    return userRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
  }
  @GetMapping("/cargo/{id}")
  List<User> getbyCoordinadores(@PathVariable Integer id) {
    return userRepository.findByCargo_Id(id);
  }
  @GetMapping("/usuario")
  List<User> get(@RequestParam String keyWord) {
    return userRepository.findByFullNameContaining(keyWord);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  User create(@RequestBody User user) {
    boolean emailAlReadyExists=userRepository.existsByEmail(user.getEmail());
    if (emailAlReadyExists){
      throw new BadRequestException("Email ready exists.");
    }
    user.setCreatedAt(LocalDateTime.now());
    user.setEstado(User.Estado.ACTIVO);
    user.setAcceso(User.Acceso.INACTIVO);
    user.setFullName(user.getFirstName()+' '+user.getLastName());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  @PutMapping("/{id}")
  User updateRRHH(
    @PathVariable Integer id,
    @RequestBody User usuForm
  ) {
    User user = userRepository.findById(id)
      .orElseThrow(EntityNotFoundException::new);
      user.setFirstName(usuForm.getFirstName());
    user.setLastName(usuForm.getLastName());
    user.setFullName(usuForm.getFirstName()+' '+usuForm.getLastName());
    user.setDni(usuForm.getDni());
    user.setTelefono(usuForm.getTelefono());
    user.setEmail(usuForm.getEmail());
    user.setEstado(usuForm.getEstado());
    user.setCargo(usuForm.getCargo());
    user.setUpdatedAt(LocalDateTime.now());
    return userRepository.save(user);
  }
  @PutMapping("/admin/{id}")
  User update(
          @PathVariable Integer id,
          @RequestBody User usuForm
  ) {
    User user = userRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);
    user.setFirstName(usuForm.getFirstName());
    user.setLastName(usuForm.getLastName());
    user.setFullName(usuForm.getFirstName()+' '+usuForm.getLastName());
    user.setDni(usuForm.getDni());
    user.setTelefono(usuForm.getTelefono());
    user.setEmail(usuForm.getEmail());
    user.setPassword(passwordEncoder.encode(usuForm.getPassword()));
    user.setEstado(usuForm.getEstado());
    user.setAcceso(usuForm.getAcceso());
    user.setCargo(usuForm.getCargo());
    user.setUpdatedAt(LocalDateTime.now());
    return userRepository.save(user);
  }
  @PutMapping("/updatepassword/{id}")
  User updatePassword(
          @PathVariable Integer id,
          @RequestBody User usuForm
  ) {
    User user = userRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);
    user.setPassword(passwordEncoder.encode(usuForm.getPassword()));
    user.setUpdatedAt(LocalDateTime.now());
    return userRepository.save(user);
  }
}

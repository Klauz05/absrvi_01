package pe.todotic.bookstoreapi_s2.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.todotic.bookstoreapi_s2.exception.BadRequestException;
import pe.todotic.bookstoreapi_s2.model.User;
import pe.todotic.bookstoreapi_s2.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
public class AccountController {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  @PostMapping("/signup")
  User signup(@RequestBody User user){
    boolean emailAlReadyExists=userRepository.existsByEmail(user.getEmail());
    if (emailAlReadyExists){
      throw new BadRequestException("Email ready exists.");
    }
    user.setCreatedAt(LocalDateTime.now());
    user.setFullName(user.getFirstName()+" "+user.getLastName());
    user.setRole(User.ROLE.USER);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }
}

package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.ConstructorResult;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.todotic.bookstoreapi_s2.model.User;
import pe.todotic.bookstoreapi_s2.repository.UserRepository;
import pe.todotic.bookstoreapi_s2.security.jwt.TokenProvider;
import pe.todotic.bookstoreapi_s2.web.dto.AuthCredentials;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class JWTController {

  private AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserRepository userRepository;
private TokenProvider tokenProvider;

  @PostMapping("/authenticate")
  ResponseEntity<AuthResponse> authenticate(@RequestBody AuthCredentials authCredentials) {
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
      authCredentials.getEmail(),
      authCredentials.getPassword()
    );
    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String accessToken = tokenProvider.createToken(authentication);

    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.AUTHORIZATION, "Bearer" + accessToken);
    User user = userRepository.findOneByEmail(authCredentials.getEmail())
      .orElseThrow(EntityNotFoundException::new);
    return ResponseEntity
      .ok()
      .headers(headers)
      .body(new AuthResponse(accessToken,user));

  }

 @AllArgsConstructor
  @Data
  static class AuthResponse{
    private String accessToken;
    private User user;
  }
}

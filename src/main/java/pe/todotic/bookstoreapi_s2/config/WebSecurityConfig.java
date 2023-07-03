package pe.todotic.bookstoreapi_s2.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pe.todotic.bookstoreapi_s2.repository.UserRepository;
import pe.todotic.bookstoreapi_s2.security.jwt.JWTConfigurer;
import pe.todotic.bookstoreapi_s2.security.jwt.TokenProvider;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {
  private final TokenProvider tokenProvider;
  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http
      .cors(Customizer.withDefaults())
      .csrf(AbstractHttpConfigurer::disable)
      .authorizeHttpRequests(
        a->a
          //.requestMatchers("api/admin/**")
          //.hasRole("ADMIN")
          .anyRequest().permitAll()
      )
      .sessionManagement(h->h.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .apply(new JWTConfigurer(tokenProvider));
    return http.build();
  }

@Bean
  public PasswordEncoder passwordEncoder(){
  return new BCryptPasswordEncoder();
}

}

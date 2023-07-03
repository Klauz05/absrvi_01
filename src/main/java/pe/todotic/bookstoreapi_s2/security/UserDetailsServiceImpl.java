package pe.todotic.bookstoreapi_s2.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.todotic.bookstoreapi_s2.model.User;
import pe.todotic.bookstoreapi_s2.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user=userRepository.findOneByEmail(username)
      .orElseThrow(()->new UsernameNotFoundException(username));
      return org.springframework.security.core.userdetails.User
        .withUsername(user.getEmail())
        .password(user.getPassword())
        .roles(user.getRole().name())
        .build();
  }
}

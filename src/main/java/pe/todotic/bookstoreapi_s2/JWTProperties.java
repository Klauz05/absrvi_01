package pe.todotic.bookstoreapi_s2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app.security.jwt")
public class JWTProperties {
  private long tokenValidityInSeconds;
  private String secret;
}

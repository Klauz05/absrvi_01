package pe.todotic.bookstoreapi_s2.web.dto;

import lombok.Data;

@Data
public class AuthCredentials {
  private String email;
  private String password;
}

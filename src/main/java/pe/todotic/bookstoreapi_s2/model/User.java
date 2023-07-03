package pe.todotic.bookstoreapi_s2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idususis")
  private Integer id;

  @NotNull(message = "No admite valor nullo")
  @Column(name = "nomusu")
  private String firstName;

  @Column(name = "apeusu")
  private String lastName;

  @Column(name = "fullname")
  private String fullName;
  @Column(name = "dniusu")
  private String dni;
  @Column(name = "telusu")
  private String telefono;

  @Column(name = "emailusu")
  private String email;

  @Enumerated(EnumType.STRING)
  private Estado estado;
  @Column(name = "feccreated")
  private LocalDateTime createdAt;
  @Column(name = "fecupdated")
  private LocalDateTime updatedAt;
  @ManyToOne
  @JoinColumn(name = "idcar", referencedColumnName = "idcar")
  private Cargo cargo;

  @Size(min = 4)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Column(name = "passusu")
  private String password;

  @Enumerated(EnumType.STRING)
  private ROLE role;

  public enum ROLE {
    ADMIN,
    USER,
    COORDINADOR,
    CONTADOR,
    CLIENT
  }
  public enum Estado {
    ACTIVO,
    INACTIVO
  }
}

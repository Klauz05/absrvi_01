package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Maeconcli {
@Id
  @Column(name = "idconcli")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "nomconcli")
private String nomConCli;
@Column(name = "emailconcli")
private String emailConCli;
  @Column(name = "carconcli")
  private String carConCli;
  @Column(name = "dirconcli")
  private String dirConCli;
  @Column(name = "fecregconcli")
  private LocalDateTime fecRegConCli;
  @ManyToOne
  @JoinColumn(name = "idcli", referencedColumnName = "idcli")
  private Cliente cliente;

}

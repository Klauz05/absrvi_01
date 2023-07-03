package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Subcliente {
  @Id
  @Column(name = "idsubcli")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "dessubcli")
  private String desSubCli;
  @Column(name = "fecregcli")
  private LocalDateTime fecRegCli;
  @ManyToOne
  @JoinColumn(name = "idcli", referencedColumnName = "idcli")
  private Cliente cliente;
}

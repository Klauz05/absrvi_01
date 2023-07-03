package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Proyecto {
  @Id
  @Column(name = "idprocli")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "desproy")
  private String desProy;
  @Column(name = "fecregpro")
  private LocalDateTime fecRegPro;
  @ManyToOne
  @JoinColumn(name = "idsubcli", referencedColumnName = "idsubcli")
  private Subcliente subcliente;
}

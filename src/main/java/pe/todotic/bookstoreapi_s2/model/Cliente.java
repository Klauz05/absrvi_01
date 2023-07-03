package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Cliente {
  @Id
  @Column(name = "idcli")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "razsoccli")
  private String razSocCli;

  @Column(name = "nomcomcli")
  private String nomComCli;

  @Column(name = "dirpricli")
  private String dirPriCli;
  @Column(name = "fecregcli")
  private LocalDateTime fecRegCli;
  @Column(name = "fecmodcli")
  private LocalDateTime fecModCli;

  @ManyToOne
  @JoinColumn(name = "idtipdoc", referencedColumnName = "idtipdoc")
  private Maetipdoc maetipdoc;

}

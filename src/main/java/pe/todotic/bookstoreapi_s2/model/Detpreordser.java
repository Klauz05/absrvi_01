package pe.todotic.bookstoreapi_s2.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Data
@Entity
public class Detpreordser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @ManyToOne
  @JoinColumn(name = "idordser", referencedColumnName = "idordser")
  private Maeordser maeordser;
  @ManyToOne
  @JoinColumn(name = "idmaerec", referencedColumnName = "idmaerec")
  private Maerec maerec;
  @Column(name = "obsdetpre")
  private String obsDetPre;
  @Column(name = "canrecpre")
  private String canRecPre;
  @Column(name = "valrecpre")
  private String valRecPre;
  @Column(name = "fecmod")
  private LocalDateTime fecMod;
  @Column(name = "idusumod")
  private LocalDateTime idUsuMod;
  @Column(name = "fecreg")
  private LocalDateTime fecReg;
  @Column(name = "idusureg")
  private LocalDateTime idUsuReg;
  @Enumerated(EnumType.STRING)
  private Estado estado;
  public enum Estado {
    ACTIVO,
    INACTIVO
  }
}

package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Detrecser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "obsrecser")
  private String obsRecSer;
  @Column(name = "fecreg")
  private LocalDateTime fecReg;
  @Column(name = "fecmod")
  private LocalDateTime fecMod;
  @Column(name = "estdetrecser")
  private Integer estDetRecSer;
  @ManyToOne
  @JoinColumn(name = "idmaerec", referencedColumnName = "idmaerec")
  private Maerec maerec;
  @ManyToOne
  @JoinColumn(name = "idordser", referencedColumnName = "idordser")
  private Maeordser maeordser;
  @Column(name = "canrecser")
  private Integer canRecSer;
  private Double precio;
}

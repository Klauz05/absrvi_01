package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Detresser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @OneToOne
  @JoinColumn(name = "idordser", referencedColumnName = "idordser")
  private Maeordser maeordser;
  @Column(name = "nomarcres")
  private String nomArcRes;
  @Column(name = "estatefin")
  private Integer estAteFin;
  @Column(name = "obsres")
  private String obsRes;
  @Column(name = "fecmodres")
  private LocalDateTime fecModRes;
  @Column(name = "fecregres")
  private LocalDateTime fecRegRes;
  @Column(name = "idusumodres")
  private Integer idUsuModRes;
  @Column(name = "idusuregres")
  private Integer idUsuRegRes;
}

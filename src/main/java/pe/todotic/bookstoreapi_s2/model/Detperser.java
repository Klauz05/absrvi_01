package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
public class Detperser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "iddetperser")
  private Integer id;
  @ManyToOne
  @JoinColumn(name = "idordser", referencedColumnName = "idordser")
  private Maeordser maeordser;
  @ManyToOne
  @JoinColumn(name = "idperser", referencedColumnName = "idususis")
  private User user;
  @Column(name = "fecperateser")
  private LocalDate fecPerAteSer;
  @Column(name = "horentper")
  private LocalTime horEntPer;
  @Column(name = "horsalper")
  private LocalTime horSalPer;
  @Column(name = "detserper")
  private String detSerPer;
  @Column(name = "monpagper")
  private Double monPagPer;
  @Column(name = "estdetperser")
  private Integer estDetPerSer;
  @Column(name = "estpagper")
  private Integer estPagPer;
  @Column(name = "fecregmodper")
  private LocalDateTime fecRegModPer;
  @Column(name = "idusumodper")
  private Integer idUsuModPer;
  @Column(name = "fecregdetper")
  private LocalDateTime fecRegDetPer;
  @Column(name = "idusuregdetper")
  private Integer idUsuRegDetPer;


}

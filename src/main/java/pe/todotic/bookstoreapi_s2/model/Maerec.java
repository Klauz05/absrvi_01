package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Maerec {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idmaerec")
  private Integer id;
  @Column(name = "desmaerec")
  private String desMaeRec;
  @Column(name = "valrec")
  private Double valRec;
  @Column(name = "estreg")
  private Integer estReg;
  @Column(name = "fecreg")
  private LocalDateTime fecReg;


}

package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "maetipdoc")
public class Maetipdoc {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idtipdoc")
  private Integer id;
  @Column(name = "destipdoc")
  private String desTipDoc;
  @Column(name = "fecregtipdoc")
  private LocalDateTime fecregtipdoc;
  private Integer logtipdoc;

}

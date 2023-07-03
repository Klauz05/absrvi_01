package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Maecencos {
@Id
  @Column(name = "idcencos")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "descencos")
private String desCenCos;
  @Column(name = "fecregcencos")
private LocalDateTime fecRegCenCos;
}

package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cargo")
public class Cargo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idcar")
  private Integer id;
  @Column(name = "descar")
  private String descar;
  @Column(name = "fecregcar")
  private LocalDateTime fecregcar;

  private Integer idusuregcar;


}

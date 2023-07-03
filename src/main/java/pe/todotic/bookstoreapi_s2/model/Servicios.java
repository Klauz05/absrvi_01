package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Servicios {
  @Id
  @Column(name = "idser")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "desser")
  private String desSer;
  @Column(name = "fecregser")
  private LocalDateTime fecRegSer;
}

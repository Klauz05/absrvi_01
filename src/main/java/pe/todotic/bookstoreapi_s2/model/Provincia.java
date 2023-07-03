package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Provincia {
  @Id
  @Column(name = "idprovincia")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  @Column(name = "desprovincia")
  private String desProvincia;
  @Column(name = "iddepartamento")
  private String idDepartamento;
}

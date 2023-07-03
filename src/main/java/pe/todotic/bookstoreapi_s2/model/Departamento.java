package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Departamento {
  @Id
  @Column(name = "iddepartamento")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  @Column(name = "desdepartamento")
  private String desDepartamento;
}

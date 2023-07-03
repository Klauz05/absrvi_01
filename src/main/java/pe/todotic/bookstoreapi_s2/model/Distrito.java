package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Distrito {
  @Id
  @Column(name = "iddistrito")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  @Column(name = "desdistrito")
  private String distrito;
  private String idprovincia;
}

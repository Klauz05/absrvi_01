package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Maeordser {
  @Id
  @Column(name = "idordser")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @ManyToOne
  @JoinColumn(name = "idcli", referencedColumnName = "idcli")
  private Cliente cliente;
  @ManyToOne
  @JoinColumn(name = "idconcli", referencedColumnName = "idconcli")
  private Maeconcli maeconcli;
  @ManyToOne
  @JoinColumn(name = "idsubcli", referencedColumnName = "idsubcli")
  private Subcliente subcliente;
  @ManyToOne
  @JoinColumn(name = "idpry", referencedColumnName = "idprocli")
  private Proyecto proyecto;
  @ManyToOne
  @JoinColumn(name = "idcencos", referencedColumnName = "idcencos")
  private Maecencos idCenCos;
  @ManyToOne
  @JoinColumn(name = "idser", referencedColumnName = "idser")
  private Servicios servicios;
  @Column(name = "turser")
  private Integer TurSer;
  @Column(name = "unimedser")
  private Integer uniMedSer;
  @Column(name = "canser")
  private Integer canSer;
  @Column(name = "freser")
  private Integer freSer;
  @Column(name = "candiafreser")
  private Integer canDiaFreSer;
  @ManyToOne
  @JoinColumn(name = "idcorasg", referencedColumnName = "idususis")
  private User coordinador;
  @Column(name = "orivenser")
  private int OriVenSer;
  @Column(name = "numorivenser")
  private String numOriVenSer;
  @Column(name = "estconser")
  private int estConSer;
  @Column(name = "estateser")
  private int estAteSer;
  @Column(name = "subestateser")
  private int subEstAteSer;
  @Column(name = "obsateser")
  private String ObsAteSer;
  @Column(name = "iddep")
  private String idDep;
  @Column(name = "idprodep")
  private String idProDep;
  @Column(name = "iddisprodep")
  private String idDisProDep;
  @Column(name = "dirser")
  private String dirSer;
  @Column(name = "desser")
  private String desSer;
  @Column(name = "conser")
  private String conSer;
  @ManyToOne
  @JoinColumn(name = "venser", referencedColumnName = "idususis")
  private User vendedor;
  @Column(name = "valser")
  private Double valSer;
  @Column(name = "preser")
  private Double preSer;
  @Column(name = "feciniser")
  private LocalDateTime fecIniSer;
  @Column(name = "fecfinser")
  private LocalDateTime fecFinSer;
  @Column(name = "fecregser")
  private LocalDateTime fecRegSer;
  @Column(name = "fecateser")
  private LocalDateTime fecAteSer;
  @Column(name = "fecliqser")
  private LocalDateTime fecLiqSer;
  @Column(name = "fecfacser")
  private LocalDateTime fecFacSer;
  @Column(name = "fecmodreg")
  private LocalDateTime fecModReg;

}

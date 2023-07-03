package pe.todotic.bookstoreapi_s2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.bookstoreapi_s2.model.Distrito;

import java.util.List;

public interface DistritoRepository extends JpaRepository<Distrito,String> {
  //Listar los distritos by idprovincia
  List<Distrito> findAllByIdprovincia(String idprovincia);
}

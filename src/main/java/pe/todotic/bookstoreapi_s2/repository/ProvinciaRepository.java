package pe.todotic.bookstoreapi_s2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.bookstoreapi_s2.model.Provincia;

import java.util.List;

public interface ProvinciaRepository extends JpaRepository<Provincia,String> {
  //Filtrar por iddepartamento
  List<Provincia> findAllByIdDepartamento(String iddepartamento);
}

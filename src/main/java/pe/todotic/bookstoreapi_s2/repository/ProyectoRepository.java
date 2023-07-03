package pe.todotic.bookstoreapi_s2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.bookstoreapi_s2.model.Proyecto;

import java.util.List;
public interface ProyectoRepository extends JpaRepository<Proyecto,Integer> {
  List<Proyecto> findBySubcliente_Id(Integer id);
}

package pe.todotic.bookstoreapi_s2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.bookstoreapi_s2.model.Detperser;
import pe.todotic.bookstoreapi_s2.model.Detpreordser;

import java.util.List;

public interface DetpreordserRepository extends JpaRepository<Detpreordser,Integer> {
  List<Detpreordser> findByMaeordser_IdAndEstado(Integer id, String estado);
}

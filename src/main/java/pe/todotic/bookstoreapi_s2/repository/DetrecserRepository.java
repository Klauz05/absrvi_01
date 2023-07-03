package pe.todotic.bookstoreapi_s2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.bookstoreapi_s2.model.Detrecser;

import java.util.List;

public interface DetrecserRepository extends JpaRepository<Detrecser,Integer> {
  List<Detrecser> findByMaeordser_IdAndEstDetRecSer(Integer id, Integer estado);
}

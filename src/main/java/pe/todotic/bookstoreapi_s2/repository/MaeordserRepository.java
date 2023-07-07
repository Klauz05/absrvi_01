package pe.todotic.bookstoreapi_s2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.bookstoreapi_s2.model.Maecencos;
import pe.todotic.bookstoreapi_s2.model.Maeordser;

import java.time.LocalDateTime;
import java.util.List;

public interface MaeordserRepository extends JpaRepository<Maeordser,Integer> {
  List<Maeordser> findByFecIniSerGreaterThanEqualAndFecIniSerLessThanEqual(LocalDateTime fecIni,LocalDateTime fecFin);
}

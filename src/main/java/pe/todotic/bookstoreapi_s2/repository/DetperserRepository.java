package pe.todotic.bookstoreapi_s2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.todotic.bookstoreapi_s2.model.Book;
import pe.todotic.bookstoreapi_s2.model.Detperser;

import java.util.List;
import java.util.Optional;

public interface DetperserRepository extends JpaRepository<Detperser,Integer> {
List<Detperser> findByMaeordser_IdAndEstDetPerSer(Integer id,Integer estado);
  @Query("select b from Detperser b where b.id = :id and b.estPagPer!=2 and b.estDetPerSer=1")
  Detperser verificar(@Param("id") Integer i);


}

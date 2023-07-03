package pe.todotic.bookstoreapi_s2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.bookstoreapi_s2.model.Maeconcli;
import java.util.List;

public interface MaeconcliRepository extends JpaRepository<Maeconcli,Integer> {
  List<Maeconcli> findByCliente_Id(Integer id);
}

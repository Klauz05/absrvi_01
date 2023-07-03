package pe.todotic.bookstoreapi_s2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.bookstoreapi_s2.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
  List<User> findByFullNameContaining(String keyword);
  List<User> findByCargo_Id(Integer id);

    // consulta para obtener un usuario a partir de un email
    Optional<User> findOneByEmail(String e);

    // consulta para sabes si existe al menos un usuario a partir de un email
    boolean existsByEmail(String e);

}

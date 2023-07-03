package pe.todotic.bookstoreapi_s2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.bookstoreapi_s2.model.Book;
import pe.todotic.bookstoreapi_s2.model.Subcliente;

import java.util.List;


public interface SubclienteRepository extends JpaRepository<Subcliente,Integer> {
  List<Subcliente> findByCliente_Id(Integer id);
}

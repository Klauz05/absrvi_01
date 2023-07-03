package pe.todotic.bookstoreapi_s2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.todotic.bookstoreapi_s2.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // consulta para saber si existe al menos un libro a partir de un slug
    boolean existsBySlug(String slug);

    // consulta para saber si existe al menos un libro a partir de un slug pero que tenga un ID distinto a uno dado
    boolean existsBySlugAndIdNot(String slug, Integer idNot);

    // consulta para obtener un solo libro a partir de un slug
    Optional<Book> findOneBySlug(String slug);

    @Query("select b from Book b where b.slug = :slug")
    Optional<Book> buscarPorSlug(@Param("slug") String s);

    // consulta los últimos 6 libros en base a la fecha de creación
    List<Book> findTop6ByOrderByCreatedAtDesc();


}

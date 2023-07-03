package pe.todotic.bookstoreapi_s2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @NotNull(message = "El título es obligatorio")
  @Size(min = 3, max = 100)
  private String title;
  @NotNull
  @Pattern(regexp = "[a-z0-9-]+")
  private String slug;
  @NotBlank
  @Column(name = "description")
  private String desc;
  @NotNull
  @Min(0)
  private Float price;
  @NotBlank
  private String coverPath;
  @NotBlank
  private String filePath;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}

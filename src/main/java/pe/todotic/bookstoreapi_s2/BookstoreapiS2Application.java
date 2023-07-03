package pe.todotic.bookstoreapi_s2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JWTProperties.class)
public class BookstoreapiS2Application {
  public String PORT=System.getenv("PORT");

	public static void main(String[] args) {
		SpringApplication.run(BookstoreapiS2Application.class, args);
	}

}

package pe.todotic.bookstoreapi_s2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig {
  @Value("${app.storage.location}")
  private String allowAcces;
  @Bean
  WebMvcConfigurer webMvcConfigurer(){
  return new WebMvcConfigurer() {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/api/**")
        //.allowedOrigins("http://161.132.222.18:8102")
        .allowedOrigins("http://localhost:4200")
        //.allowedOrigins("https://64a841dc4686af05ad5f4b8c--splendid-valkyrie-4d5308.netlify.app/")
        .allowedMethods("*")
        .exposedHeaders("*");
    }
  };
}
}

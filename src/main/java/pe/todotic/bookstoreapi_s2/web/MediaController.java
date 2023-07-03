package pe.todotic.bookstoreapi_s2.web;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.todotic.bookstoreapi_s2.service.FileSystemStorageService;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@RestController
@RequestMapping("/api/media")
public class MediaController {
@Autowired
  private FileSystemStorageService fileSystemStorageService;
@PostMapping("/upload")
Map<String,String> upload(@RequestParam("File") MultipartFile multipartFile){
  String path=fileSystemStorageService.store(multipartFile);
  return Map.of("path",path);
}
@GetMapping("/{filename}")
ResponseEntity<Resource> getResource(@PathVariable String filename) throws IOException {
  Resource resource=fileSystemStorageService.loadAsResource(filename);
  String contentType= Files.probeContentType(resource.getFile().toPath());
  return ResponseEntity
    .ok()
    .header(HttpHeaders.CONTENT_TYPE,contentType)
    .body(resource);
}

}

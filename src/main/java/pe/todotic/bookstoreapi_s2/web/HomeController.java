package pe.todotic.bookstoreapi_s2.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pe.todotic.bookstoreapi_s2.model.Book;
import pe.todotic.bookstoreapi_s2.model.SalesItem;
import pe.todotic.bookstoreapi_s2.model.SalesOrder;
import pe.todotic.bookstoreapi_s2.repository.BookRepository;
import pe.todotic.bookstoreapi_s2.repository.SalesOrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private SalesOrderRepository salesOrderRepository;
   @GetMapping("/last-books")
  List<Book> getLastBooks(){
     return bookRepository.findTop6ByOrderByCreatedAtDesc();
   }

   @GetMapping
  Page<Book> getBooks(@PageableDefault(sort="title")Pageable pageable){
     return bookRepository.findAll(pageable);
   }
   @GetMapping("/books/{slug}")
  Book getBook(@PathVariable String slug){
     return bookRepository.findOneBySlug(slug).orElseThrow(EntityNotFoundException::new);
   }
   @GetMapping("/orders/{id}")
   SalesOrder getOrder(@PathVariable Integer id){
     return salesOrderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
   }
   @PostMapping("/orders")
   SalesOrder createdOrder(@RequestBody List<Integer> bookIds){
     SalesOrder salesOrder=new SalesOrder();
     List<SalesItem> items=new ArrayList<>();
     float total=0;
     for(int bookid:bookIds){
       Book book= bookRepository.findById(bookid).orElseThrow(EntityNotFoundException::new);
       SalesItem salesItem=new SalesItem();
       salesItem.setBook(book);
       salesItem.setPrice(book.getPrice());
       salesItem.setDownloadsAvailable(3);
       salesItem.setOrder(salesOrder);
       items.add(salesItem);
       total+=salesItem.getPrice();
     }
     salesOrder.setPaymentStatus(SalesOrder.PaymentStatus.PENDING);
     salesOrder.setCreatedAt(LocalDateTime.now());
     salesOrder.setTotal(total);
     salesOrder.setItems(items);
     return salesOrderRepository.save(salesOrder);
   }
}

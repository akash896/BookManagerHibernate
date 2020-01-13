package RestClasses;

import net.codejava.hibernate.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import packageDAO.BookDAO;
import packageDAO.BookDAOImpl;

@RestController
public class MainController {

    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    BookDAO bookDAO = context.getBean("BookDAOImpl", BookDAO.class);

    @RequestMapping("/BookStore")
    public String welcome() {
        return "Welcome to the BookStore ";
    }

    @PostMapping(path = "/BookStore/create/Book", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createBook(@RequestBody Book book) {
        bookDAO.create(book);
        return "Book created";
    }

    @GetMapping(path = "/BookStore/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Book> getBook(@PathVariable int id) {
        Book b = bookDAO.read(id);
        return ResponseEntity.ok(b);
    }

    @PutMapping(path = "/BookStore/update/Book", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateBook(@RequestBody Book book) {
        bookDAO.update(book);
        return "Book updated ";
    }

    @DeleteMapping(path = "/BookStore/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookDAO.delete(id);
        return "Book deleted ";
    }
}

package packageDAO;

import net.codejava.hibernate.Book;
import net.codejava.hibernate.Connect;
import org.hibernate.Session;

public class BookDAOImpl implements BookDAO {
    public void create(Book book) {
        // code to save a book
        Session session = Connect.setup().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    public Book read(long id) {
        // code to get a book
        Session session = Connect.setup().openSession();
        Book book = session.get(Book.class, id);
        /*System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price: " + book.getPrice());*/
        session.close();
        return book;
    }

    public void update(Book book) {
        // code to modify a book
        Session session = Connect.setup().openSession();
        session.beginTransaction();
        session.update(book);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        // code to remove a book
        Book book = new Book();
        book.setId(id);
        Session session = Connect.setup().openSession();
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
        session.close();
    }
}

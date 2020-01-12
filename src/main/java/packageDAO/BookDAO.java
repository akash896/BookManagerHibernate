package packageDAO;

import net.codejava.hibernate.Book;

public interface BookDAO {
    void create(Book book);
    Book read(long id);
    void update(Book book);
    void delete(int id);
}

package net.gentledot.demospringcore.demo.book;

import org.springframework.stereotype.Repository;

@Repository
public class AnotherBookRepository implements BookRepository {
    @Override
    public Book save(Book book) {
        return null;
    }
}

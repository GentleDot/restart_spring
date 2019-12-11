package net.gentledot.demospringcore.demo.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository @Primary
public class MyBookRepository implements BookRepository {

    @Override
    public Book save(Book book) {
        return null;

    }
}

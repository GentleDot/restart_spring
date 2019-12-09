package net.gentledot.demospringcore.demo.book;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        book.setCreated(new Date());
        book.setBookStatus(BookStatus.DRAFTED);
        return bookRepository.save(book);
    }
}

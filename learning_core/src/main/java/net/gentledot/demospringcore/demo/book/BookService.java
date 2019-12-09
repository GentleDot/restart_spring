package net.gentledot.demospringcore.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void postConstruct(){
        System.out.println("===================");
        System.out.println("Hello SpringBoot");
        System.out.println("===================");
    }
}

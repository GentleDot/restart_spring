package net.gentledot.demospringcore.demo.book;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

     /*
     @RunWith(SpringRunner.class) 에서는 Mock인 bookRepository 가 null이 아니지만
     @ExtendWith(MockitoExtension.class) 에서는 Mock이 null인 상태가 되어 NullPointerException 이 발생함
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {
        Book book = new Book();
        BookService bookService = new BookService(bookRepository);

        when(bookRepository.save(book)).thenReturn(book);

        Book saveResult = bookService.save(book);

        assertThat(book.getCreated()).isNotNull();
        assertThat(book.getBookStatus()).isEqualTo(BookStatus.DRAFTED);
        assertThat(saveResult).isNotNull();


    }
}
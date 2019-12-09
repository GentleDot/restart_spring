package net.gentledot.demospringcore.demo.book;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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
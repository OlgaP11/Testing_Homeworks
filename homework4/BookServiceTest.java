package homework4;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {
    private BookRepository bookRepositoryMock;
    private BookService bookService;

    @BeforeEach
    public void setUp(){
        bookRepositoryMock = mock(InMemoryBookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }

    @Test
    public void findBookByIdTest(){
        Book bookMock = mock(Book.class);

        when(bookRepositoryMock.findById("1")).thenReturn(bookMock);
        when(bookService.findBookById("1")).thenReturn(bookMock);


        Book res = bookService.findBookById("1");
        verify(bookRepositoryMock, times(1)).findById("1");
        assertEquals(res, bookRepositoryMock.findById("1"));
    }

    @Test
    public void findAllBooksTest(){
        List<Book> mockedListOfBooks = mock(List.class);

        when(bookRepositoryMock.findAll()).thenReturn(mockedListOfBooks);
        when(bookService.findAllBooks()).thenReturn(mockedListOfBooks);

        List<Book> res = (List<Book>) bookService.findAllBooks();
        verify(bookRepositoryMock, times(1)).findAll();
        assertEquals(res, bookRepositoryMock.findAll());

    }
}


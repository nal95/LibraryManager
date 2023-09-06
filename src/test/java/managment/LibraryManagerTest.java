package managment;


import books.Book;
import org.junit.jupiter.api.*;
import users.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class LibraryManagerTest {

    private LibraryManager instance;
    private User user;
    private Book book;

    @BeforeEach
    public void setUp() {
        instance = LibraryManager.getInstance();
        user = new User("user", "User");
        book = new Book("book", "author", 1950, "11111-0");
        instance.addBook(book);
    }

    @AfterEach
    public void setDown() {
        instance = null;
        user = null;
        book = null;
    }

    @Test
    public void getInstance() {
        LibraryManager instanceOne = LibraryManager.getInstance();

        assertNotNull(instance);
        assertNotNull(instanceOne);
        assertSame(instanceOne, instance);
    }

    @Test
    public void returnBookThatWasBorrowed() {
        instance.borrowBook(user, book);
        assertTrue(book.isBorrowed());

        instance.returnBook(user, book);
        assertFalse(book.isBorrowed());
    }

    @Test
    public void returnBookThatWasNotBorrowed() {
        Book book1 = new Book("book1", "author1", 1950, "11111-1");
        instance.addBook(book1);
        instance.borrowBook(user, book);

        instance.returnBook(user, book1);
        assertFalse(book1.isBorrowed());
    }

    @Test
    public void borrowABookThatIsAvailable() {
        instance.borrowBook(user, book);
        assertTrue(book.isBorrowed());
        assertNotNull(instance.getBorrowingBooksByUser(user));
        assertEquals(1, instance.getBorrowingBooksByUser(user).size());
        assertEquals(book, instance.getBorrowingBooksByUser(user).get(0));
    }

    @Test
    public void borrowABookThatIsNotAvailable() {
        Book book1 = new Book("book1", "author1", 1950, "11111-1");

        instance.borrowBook(user, book1);
        assertNull(instance.getBorrowingBooksByUser(user));
        assertFalse(book1.isBorrowed());
    }

    @Test
    public void borrowABookThatWasAlreadyBorrowed() {
        instance.borrowBook(user, book);

        User user1 = new User("user1", "User1");
        instance.borrowBook(user1, book);
        assertNull(instance.getBorrowingBooksByUser(user1));
    }

//TODO: FIX ME

//    @Test
//    public void findBookByAuthor() {
//        Book book1 = new Book("book1", "author", 1950, "11111-1");
//        instance.addBook(book1);
//
//        List<Book> books = instance.findBookByAuthor(book.getAuthor());
//        assertNotNull(books);
//        assertEquals(2, books.size());
//        assertEquals(book.toString(), books.get(0).toString());
//        assertEquals(book1.toString(), books.get(1).toString());
//    }
//
//    @Test
//    public void getBorrowingsInProgress() {
//        instance.borrowBook(user, book);
//        Borrowing borrowing = new Borrowing(book, user);
//
//        assertNotNull(instance.getBorrowingsInProgress());
//        assertEquals(1, instance.getBorrowingsInProgress().size());
//        assertEquals(borrowing.toString(), instance.getBorrowingsInProgress().get(0).toString());
//    }
//
//    @Test
//    public void getBooks() {
//        Book book1 = new Book("book1", "author1", 1950, "11111-1");
//        Book book2 = new Book("book1", "author2", 1950, "11111-2");
//
//        instance.addBook(book1);
//        instance.addBook(book2);
//
//        List<Book> books = instance.getBooks();
//
//        assertNotNull(books);
//        assertEquals(3, books.size());
//    }

    @Test
    public void addBook() {
        Book book1 = new Book("book1", "author1", 1950, "11111-1");
        instance.addBook(book1);

        List<Book> books = instance.getBooks();

        assertNotNull(books);
        assertEquals(2, books.size());
        assertEquals(book, instance.getBooks().get(0));
        assertEquals(book1, instance.getBooks().get(1));
    }

    @Test
    public void getBorrowingBooksByUser() {
        Book book1 = new Book("book1", "author1", 1950, "11111-1");
        instance.addBook(book1);
        instance.borrowBook(user, book);
        instance.borrowBook(user, book1);

        List<Book> books = instance.getBorrowingBooksByUser(user);
        assertNotNull(books);
        assertEquals(2, books.size());
    }
}
package books;

import users.User;

import java.time.LocalDate;

public class Borrowing {
    private Book book;
    private User user;
    private LocalDate borrowingDate;
    private LocalDate expectedReturnDate;

    public Borrowing(Book book, User user) {
        book.borrowed();
        this.book = book;
        this.user = user;
        this.borrowingDate = LocalDate.now();
        this.expectedReturnDate = borrowingDate.plusDays(30);

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "book=" + book +
                ", user=" + user +
                ", borrowingDate=" + borrowingDate +
                ", expectedReturnDate=" + expectedReturnDate +
                '}';
    }
}

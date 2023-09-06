package managment;

import books.Book;
import books.Borrowing;
import users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryManager {
    private static LibraryManager instance;
    private List<Borrowing> borrowingsInProgress;
    private List<Book> books;

    private LibraryManager() {
        borrowingsInProgress = new ArrayList<>();
        books = new ArrayList<>();
    }

    // Méthode pour obtenir l'instance unique de la classe
    public static LibraryManager getInstance() {
        if (instance == null) {
            instance = new LibraryManager();
        }
        return instance;
    }

    public void returnBook(User user, Book book) {

        Borrowing borrowing = findBorrowing(user, book);

        if (borrowing != null) {
            // Supprimez l'emprunt de la liste des emprunts en cours
            book.returned();
            borrowingsInProgress.remove(borrowing);

            // Effectuez d'autres opérations, par exemple, mettre à jour la date de retour réelle, etc.
            System.out.println(user.getLastName() + " returned the book : " + book.getTitle());
        } else {
            System.out.println("No borrowing found for " + user.getLastName() + " and the book " + book.getTitle());
        }
    }

    public void borrowBook(User user, Book book) {
        if (checkBookAvailiability(book) == null) {

            System.out.println("Book " + book.getTitle() + " is not available in our  Library");

        } else if (findBorrowing(user, book) != null) {

            System.out.println("User " + user.getLastName() + " already owns book " + book.getTitle() + " cannot therefore not borrow it again");

        } else {

            Borrowing borrowing = new Borrowing(book, user);
            borrowingsInProgress.add(borrowing);
            books.remove(book);
            System.out.println("Book " + book.getTitle() + " has just been hired from " + user.getLastName() + "." + "\nTo be delivered on : " + borrowing.getExpectedReturnDate());
        }
    }

    public List<Book> findBookByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Borrowing> getBorrowingsInProgress() {
        return borrowingsInProgress;
    }

    public List<Book> getBooks() {
        books.forEach(book -> {
            System.out.println( '\n' + book.toString());
        });

        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getBorrowingBooksByUser(User user) {
        List<Book> books = findBorrowingBooksByUser(user);
        if (books.isEmpty()) {

            System.out.println("User " + user.getLastName() + " has not borrowed any books");
            return  null;

        } else {
            books.forEach(book -> {
                System.out.println("Book:  " + book.getTitle() + "\nAuthor: " + book.getAuthor());
            });
            return books;
        }
    }

    private List<Book> findBorrowingBooksByUser(User user) {

        return borrowingsInProgress.stream()
                .filter(b -> b.getUser().equals(user))
                .map(Borrowing::getBook)
                .collect(Collectors.toList());
    }

    // Méthode utilitaire pour trouver un emprunt en cours
    private Borrowing findBorrowing(User user, Book book) {
        for (Borrowing borrowing : borrowingsInProgress) {
            if (borrowing.getUser().equals(user) && borrowing.getBook().equals(book)) {
                return borrowing;
            }
        }
        return null; // Aucun emprunt trouvé
    }

    private Book checkBookAvailiability(Book book) {
        return books.stream().filter(b -> b.equals(book)).findFirst().orElse(null);
    }

}

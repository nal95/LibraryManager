import books.Book;
import managment.LibraryManager;
import users.User;

public class Main {
    public static void main(String[] args) {
        LibraryManager library = LibraryManager.getInstance();

        Book book1 = new Book("Le Seigneur des Anneaux", "J.R.R. Tolkien", 1954, "978-2-266-11111-2");
        Book book2 = new Book("1984", "George Orwell", 1949, "978-0-452-28423-4");
        Book book3 = new Book("Harry Potter et la pierre philosophale", "J.K. Rowling", 1997, "978-2-266-12345-6");
        Book book4 = new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "978-0-452-28456-7");

        User user1 = new User("Alice", "Tsafack");
        User user2 = new User("Bob", "Dongmo");

        System.out.println(user1);
        System.out.println("\n========================================\n");
        System.out.println(user2);
        System.out.println("\n========================================\n");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        library.getBooks();

        System.out.println("\n========================================\n");

        library.borrowBook(user2, book3);
        System.out.println("\n========================================\n");
        library.borrowBook(user2, book3);
        System.out.println("\n========================================\n");
        library.borrowBook(user2, book1);
        System.out.println("\n========================================\n");
        library.borrowBook(user1, book4);
        System.out.println("\n========================================\n");
        library.borrowBook(user1, book4);

    }
}

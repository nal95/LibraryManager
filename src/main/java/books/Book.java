package books;

public class Book {

    private String title;
    private String author;
    private int publicationYear;
    private String ISBN;
    private boolean isBorrowed;

    public Book( String title, String author, int publicationYear, String ISBN){
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isBorrowed() {
        return this.isBorrowed;
    }

    public void borrowed() {
        this.isBorrowed = true;
    }

    public void returned() {
        this.isBorrowed = false;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book {" +
                " title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear='" + publicationYear + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", is borrowed='" + isBorrowed + '\'' +
                " }";
    }
}

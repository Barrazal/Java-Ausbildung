public class Book {
    private Integer id;
    private String name;
    private String isbn;
    private boolean available;
    private static int count;
    Book nextBook;
    Book prevBook;


    public Book() {
        this.id = null;
        this.name = null;
        this.isbn = null;
        this.available = false;
        this.nextBook = null;
        this.prevBook = null;
    }


    public Book(Integer id, String name, String isbn, boolean available) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.available = available;
        this.nextBook = null;
        this.prevBook = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getNextBook() {
        return nextBook;
    }

    public void setNextBook(Book nextBook) {
        this.nextBook = nextBook;
    }

    public Book getPrevBook() {
        return prevBook;
    }

    public void setPrevBook(Book prevBook) {
        this.prevBook = prevBook;
    }

    public void resetConnection(){
        this.prevBook = null;
        this.nextBook = null;
    }

    public String bookOutput() {
        return "\nid: " + id +
                ", name: " + name +
                ", isbn: " + isbn +
                ", available: " + available +
                "";
    }
}

package oop1AndOop2_exercises.genericList;
public class Book {
    private Integer id;
    private String name;
    private String isbn;
    private boolean available;


    public Book() {
        this.id = null;
        this.name = null;
        this.isbn = null;
        this.available = false;

    }


    public Book(Integer id, String name, String isbn, boolean available) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.available = available;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", name: " + name +
                ", isbn: " + isbn +
                ", available: " + available +
                "";
    }
}

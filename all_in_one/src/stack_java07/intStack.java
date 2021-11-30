package stack_java07;

import double_linked_list.Book;
import double_linked_list.BookList;

public class intStack {
    private final static Integer maxInteger = 20;
    private Book start;
    private BookList bookStack = new BookList();

    public void push(Integer id, String name, String isbn, boolean available) throws StackTooSmallException {
        if (bookStack.getListCount() == maxInteger) {
            throw new StackTooSmallException();
        }
        bookStack.add(id, name, isbn, available);
    }

    public void size() {
        System.out.printf("Der Stack hat eine größe von: '%d'\n", bookStack.getListCount());
    }

    public void pop() {
        Book lastBook = bookStack.getEnd().getPrevBook();
        int delLastId = lastBook.getId();

        System.out.println(lastBook.bookOutput());
        bookStack.delete(delLastId);
    }

    public void peek() {
        Book lastBook = bookStack.getEnd().getPrevBook();
        System.out.println("Das Letzte Element des Stack ist: " + lastBook.bookOutput());
    }

    public void pop(int n) {
        System.out.printf("Output and delete '%d' elements from Stack: \n", n);
        for (int i = 0; i < n; i++) {
            Book lastBook = bookStack.getEnd().getPrevBook();
            int delLastId = lastBook.getId();
            System.out.println(lastBook.bookOutput());
            bookStack.delete(delLastId);

        }

    }


}


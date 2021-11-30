package stack02_java07;

import double_linked_list.Book;

public class intStack {
    private final static Integer maxInteger = 10;
    private int size = -1;


    public void push(Integer id, String name, String isbn, boolean available) throws StackTooSmallException {
        if (size == maxInteger) {
            throw new StackTooSmallException();
        }
        Book newBook = new Book(id,name,isbn,available);

    }

   // public int size() {
//
   // }
//
   // public int pop() {
//
//
   // }
//
   // public int peek() {
//
   // }
//
   // public int[] pop(int value) {
//
//
   // }


}


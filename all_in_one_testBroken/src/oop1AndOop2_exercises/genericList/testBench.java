package oop1AndOop2_exercises.genericList;

public class testBench {
    public static void main(String[] args) throws StackTooSmallException {
//    Cat cat1 = new Cat("cat1", "cat1-1-2");
//    Cat cat2 = new Cat("cat2", "cat2-1-2");
//    Cat cat3 = new Cat("cat3", "cat3-1-2");
//    Cat cat4 = new Cat("cat4", "cat4-1-2");
//    Cat cat5 = new Cat("cat5", "cat5-1-2");
//    Cat cat6 = new Cat("cat6", "cat6-1-2");
//    Cat cat7 = new Cat("cat7", "cat7-1-2");
//    Cat cat8 = new Cat("cat8", "cat8-1-2");
//    Cat cat9 = new Cat("cat9", "cat9-1-2");

//    GenericDoubleLinkedList<Cat> catList = new GenericDoubleLinkedList<>("CatList1");
//
//    catList.add(cat1);
//    catList.add(cat2);
//    catList.add(cat3);
//    catList.add(cat4);
//    catList.add(cat5);
//    catList.add(cat6);
//    catList.add(cat7);
//    catList.add(cat8);
//    catList.add(cat9);
//    catList.add(new Cat("cat10", "cat10-1-2"));
//
//    System.out.println();
//    System.out.println("######Cat-print:");
//    catList.print();
//

//  Book book2 = new Book(2, "Book2", "DE-123-GA412-fads3", true);
//  Book book3 = new Book(3, "Book3", "DE-123-GA412-fads3", true);
//  Book book4 = new Book(4, "Book4", "DE-123-GA412-fads3", true);
//  Book book5 = new Book(5, "Book5", "DE-123-GA412-fads3", true);
//  Book book6 = new Book(6, "Book6", "DE-123-GA412-fads3", true);
//  Book book7 = new Book(7, "Book7", "DE-123-GA412-fads3", true);
//  Book book8 = new Book(8, "Book8", "DE-123-GA412-fads3", true);
//    Book book9 = new Book(9, "Book9", "DE-123-GA412-fads3", true);
//  Book book10 = new Book(10, "Book10", "DE-123-GA412-fads3", true);
//    Book book11 = new Book(11, "Book11", "DE-123-GA412-fads3", true);
//    Book book12 = new Book(12, "Book12", "DE-123-GA412-fads3", true);
//    Book book13 = new Book(13, "Book13", "DE-123-GA412-fads3", true);
//    Book book14 = new Book(14, "Book14", "DE-123-GA412-fads3", true);
//    Book book15 = new Book(15, "Book15", "DE-123-GA412-fads3", true);
//    Book book16 = new Book(16, "Book16", "DE-123-GA412-fads3", true);

//  GenericDoubleLinkedList<Book> bookList = new GenericDoubleLinkedList<>();
//  bookList.add(new Book(1, "Book1", "DE-123-GA412-fads3", true));
//  bookList.add(book2);
//  bookList.add(book3);
//  bookList.add(book4);
//  bookList.add(book5);
//  bookList.add(book6);
//  bookList.add(book7);
//  bookList.addBefore(book6,book8);
//    bookList.add(book9);
//    bookList.add(book10);
//    bookList.add(book11);
//    bookList.add(book12);
//    bookList.add(book13);
//    bookList.add(book14);
//    bookList.add(book15);
//    bookList.add(book16);
//
//  System.out.println();
//  System.out.println("######BookList1-print:");
//  bookList.print();

//  System.out.println();
//  System.out.println("######BookList1-Reverse-Print:");
//  bookList.printReverse();

//  System.out.println();
//  System.out.println("######BookList1-Reverse-Print:");
//  bookList.listLength();

//  System.out.println();
//  System.out.println("######BookList1-seekList:");
//  bookList.seekList(book2);
//  bookList.seekList(book10);

//  System.out.println();
//  System.out.println("######BookList1-seekList:");
//  bookList.seekListReverse(book4);
//  bookList.seekListReverse(book10);
        Integer i2 = 2;
        Integer i3 = 3;
        Integer i4 = 4;
        Integer i5 = 5;
        Integer i6 = 6;
        Integer i7 = 7;
        Integer i8 = 8;
        Integer i9 = 9;


        IntStack stackInt1 = new IntStack<>();

        System.out.println();
        System.out.println("Size from StackInt1 before insert Value: ");
        stackInt1.size();


        stackInt1.push(1);
        stackInt1.push(i2);
        stackInt1.push(i8);
        stackInt1.push(i5);
        stackInt1.push(i9);
        stackInt1.push(i4);
        stackInt1.push(i6);
        stackInt1.push(i3);
        stackInt1.push(i7);



        System.out.println();
        System.out.println("Size from StackInt1 after insert Value: ");
        stackInt1.size();

        System.out.println();
        System.out.println();
        System.out.println();

        stackInt1.pop();
        stackInt1.size();
        stackInt1.peek();

        System.out.println();
        System.out.println();
        System.out.println();

        stackInt1.pop(4);
        stackInt1.size();
        stackInt1.peek();


    }

}

// Referenz der Uebung: https://www.straub.as/c-cpp-qt-fltk/c/double-linked-list.html#:~:text=Eine%20doppelt%20verkettete%20Liste%20ist,auf%20das%20vorhergehende%20Element%20zeigt.

package double_linked_lists.doubleLinkedList_forBooks;

public class BookList {
    private Book start;
    private Book end;
    private int listCount = 0;
    private String listName;

    public BookList() {
        start = new Book();
        end = new Book();
        start.nextBook = end;
        end.prevBook = start;
        this.listName = null;
    }
    public BookList(String listName) {
        start = new Book();
        end = new Book();
        start.nextBook = end;
        end.prevBook = start;
        this.listName = listName;
    }

    public void add(Integer id, String name, String isbn, boolean available) {
        Book newBook = new Book(id, name, isbn, available);

        Book save = end.prevBook;

        end.prevBook = newBook;

        newBook.prevBook = save;

        newBook.nextBook = end;

        save.nextBook = newBook;

        listCount++;
    }

    public void addBefore(Integer idBefore, Integer id, String name, String isbn, boolean available) {

        Book saveBefore;
        Book newBook = new Book(id, name, isbn, available);

        saveBefore = start.getNextBook();


        while (saveBefore != null) {

            if (saveBefore.getId().equals(idBefore)) {
                newBook.setPrevBook(saveBefore);
                saveBefore.getPrevBook().setNextBook(newBook);
                saveBefore.setPrevBook(newBook);
                newBook.setNextBook(saveBefore);
                listCount++;
                break;

            }
            saveBefore = saveBefore.getNextBook();

        }
    }

    public void output() {
        Book outputAll = start.getNextBook();
        System.out.print("\n\n" + listName + ", Bookcount: " + listCount);
        while (outputAll.getNextBook() != null) {
            System.out.print(outputAll.bookOutput());
            outputAll = outputAll.nextBook;
        }
    }

    public void outputReverse() {
        Book outputReverse = end.getPrevBook();
        System.out.print("\n" + listName + ", Bookcount: " + listCount + "Reverse Output");
        while (outputReverse.getPrevBook() != null) {
            System.out.print(outputReverse.bookOutput());
            outputReverse = outputReverse.prevBook;
        }
        System.out.println();
    }

    public void listLength() {
        System.out.println("\n" + listName + " has " + listCount + " Books in it´s Inventory");
    }

    public String seekList(Integer id) {

        Book seekList = start.getNextBook();
        System.out.print("\nSearch for id " + id + " in the List: " + listName);
        if (seekList.nextBook != null) {
            while (seekList.getId() != id) {
                seekList = seekList.getNextBook();
            }
            System.out.println(seekList.bookOutput());
        }
        return null;
    }

    public String seekListReverse(Integer id) {

        Book seekListReverse = end.getPrevBook();
        System.out.print("\nReverse Search for id " + id + " in the List: " + listName);
        if (seekListReverse.prevBook != null) {
            while (seekListReverse.getId() != id) {
                seekListReverse = seekListReverse.getPrevBook();
            }
            System.out.println(seekListReverse.bookOutput());
        }
        return null;
    }

    public void delListAfter(Integer id) {
        Book actualBook = start.getNextBook();
        Book lastBook = end.getPrevBook().getNextBook();
        Book saveNext;
        int localcount = 0;
        id--;

        for (int i = 0; i < listCount; i++) {
            if (i < id) {
                actualBook = actualBook.getNextBook();
                localcount++;
            } else if (i == id) {
                saveNext = actualBook.getNextBook();
                actualBook.setNextBook(lastBook);
                lastBook.setPrevBook(actualBook);
                actualBook = saveNext;
                localcount++;
            } else if (i >= id && actualBook.getNextBook() != end) {

                saveNext = actualBook.getNextBook();
                saveNext.setPrevBook(null);
                actualBook.setNextBook(null);
                actualBook.setPrevBook(null);
                actualBook = saveNext;


            } else if (actualBook.getNextBook() == end) {
                this.listCount = localcount;
                return;
            }
        }
    }

    public void delete(Integer id) {
        Book actualBook = start.getNextBook();
        Book saveBefore;
        Book saveAfter;

        while (actualBook.getId() != id && actualBook.getNextBook() != null) {
            actualBook = actualBook.getNextBook();
        }
        saveBefore = actualBook.getPrevBook();
        saveAfter = actualBook.getNextBook();

        actualBook.setNextBook(null);
        actualBook.setPrevBook(null);

        saveAfter.setPrevBook(saveBefore);

        saveBefore.setNextBook(saveAfter);
        listCount--;
    }

    public Book getEnd() {
        return end;
    }

    public int getListCount() {
        return listCount;
    }
}

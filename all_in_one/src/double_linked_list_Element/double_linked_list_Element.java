

package double_linked_list_Element;

import double_linked_list.Book;

public class double_linked_list_Element<T> {

    private Node start;
    private Node end;
    private int listCount = 0;
    private String listName;
    Node nextNode;
    Node prevNode;

    public double_linked_list_Element() {
        start = new Node();
        end = new Node();
        start.next = end;
        end.previous = start;
        this.listName = null;
        this.nextNode = null;
        this.prevNode = null;
    }

//    public double_linked_list_Element(String listName) {
//        start = new Node();
//        end = new Node();
//        start.next = end;
//        end.previous = start;
//        this.listName = listName;
//    }

    private class Node<T> {
        private T value;
        private Node next;
        private Node previous;
    }


    public void add(Integer id, String name, String isbn, boolean available) {
        Node newNode = new Node();
        Node saveNode = end.previous;
        end.previous = newNode;
        newNode.previous = saveNode;
        newNode.next = end;
        saveNode.next = newNode;

        listCount++;
    }

    public void addBefore(Integer idBefore, Integer id, String name, String isbn, boolean available) {

        Node saveBefore;
        Node newNode = new Node();

        saveBefore = start.getNextNode();


        while (saveBefore != null) {

            if (saveBefore.getId().equals(idBefore)) {
                newNode.setPrevBook(saveBefore);
                saveBefore.getPrevBook().setNextBook(newNode);
                saveBefore.setPrevBook(newNode);
                newNode.setNextBook(saveBefore);
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

        return null;
    }

    public String seekListReverse(Integer id) {

        return null;
    }


    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public void resetConnection(){
        this.prevNode = null;
        this.nextNode = null;
    }

}

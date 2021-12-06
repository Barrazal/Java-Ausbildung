package double_linked_lists.genericList;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

//In Java Collections, we use T for type, K for key and V for value.
public class GenericDoubleLinkedList<T> implements Collection, List {
    private Element<T> start;
    private Element<T> end;
    private int size;
    private String listName;

    public GenericDoubleLinkedList(String listname) {
        start = new Element<>(null);
        end = new Element<>(null);
        start.nextElem = end;
        end.prevElem = start;
        this.listName = listname;
        size = 0;
    }

    public GenericDoubleLinkedList() {
        start = new Element<>(null);
        end = new Element<>(null);
        start.nextElem = end;
        end.prevElem = start;
        this.listName = "noName";
        size = 0;
    }

    //it´s a way, but not the right way!
    //  public void add(T element) {
    //      Element<T> newElem = new Element<>(element);
    //      newElem.setPrevElem(start);
    //      newElem.getPrevElem().setNextElem(newElem);
//
    //      newElem.setNextElem(end);
    //      newElem.getNextElem().setPrevElem(newElem);
    //      size++;
    //  }

    //Fancy! it Works!


    //it´s a way, but not the right way!
    //   public void print() {
    //       Element<T> currentNode = start;
    //       while (currentNode != null) {
    //           System.out.println(currentNode.getValue());
    //           currentNode = currentNode.getNextElem();
    //       }
    //   }

    //Fancy! it Works!
    public void print() {
        Element<T> currentNode = start.getNextElem();
        while (currentNode.getNextElem() != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNextElem();
        }
    }

    public void printReverse() {
        Element<T> currentNode = end.getPrevElem();
        while (currentNode.getPrevElem() != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getPrevElem();
        }
    }

    @Override
    public boolean add(Object element) {
        Element<T> newElem = new Element(element);
        Element<T> lastElem = end.prevElem;
        end.prevElem = newElem;
        newElem.setPrevElem(lastElem);
        newElem.setNextElem(end);
        lastElem.setNextElem(newElem);
        size++;
        return true;
    }

    public void listLength() {
        System.out.println("\n" + listName + " has " + size + " Elements in it´s Inventory");
    }

    public void addBefore(T elementBefore, T element) {
        Element<T> saveBefore;
        Element<T> newElement = new Element<>(element);
        saveBefore = start.getNextElem();

        while (saveBefore != null) {
            if (saveBefore.getValue().equals(elementBefore)) {
                newElement.setNextElem(saveBefore);
                newElement.setPrevElem(saveBefore.getPrevElem());
                newElement.getNextElem().setPrevElem(newElement);
                newElement.getPrevElem().setNextElem(newElement);
                size++;
                break;
            }
            saveBefore = saveBefore.getNextElem();
        }
    }


    public void seekList(T element) {

        Element<T> seekList = start.getNextElem();
        if (seekList.getNextElem() != null) {
            for (int i = 0; i < size; i++) {
                if (seekList.getValue().equals(element)) {
                    System.out.println(seekList.getValue());
                    ;
                } else if (i == size && !seekList.getValue().equals(element)) {
                    System.out.println("Element not Found");
                }
                seekList = seekList.getNextElem();
            }
        } else {
            System.out.println("No Elements in List!");
        }
    }

    {
        System.out.println("No Elements in List!");
    }

    public void seekListReverse(T element) {
        Element<T> seekListReverse = end.getPrevElem();
        if (seekListReverse.prevElem != null) {
            for (int i = 0; i < size; i++) {
                if (seekListReverse.getValue().equals(element)) {
                    System.out.println(seekListReverse.getValue());
                } else if (i == size && !seekListReverse.getValue().equals(element)) {
                    System.out.println("Element not Found");
                }
                seekListReverse = seekListReverse.getPrevElem();
            }
        } else {
            System.out.println("No Elements in List!");
        }
    }

    public void delListAfter(T element){
        Element <T> actualElement = start.getNextElem();
        Element <T> saveNext;

        for (int i = 0; i < size; i++){
            if (actualElement.getValue() == element){
                saveNext = actualElement.getNextElem();
                actualElement.setNextElem(end);
                end.setPrevElem(actualElement);
            }



                actualElement = actualElement.getNextElem();
        }


    }

    @Override
    public boolean remove(Object element) {
        Element<T> actualElem = start.getNextElem();
        Element<T> elemBef;
        Element<T> elemAft;
        while (actualElem.getValue() != element && actualElem.getNextElem() != null) {
            actualElem = actualElem.getNextElem();
        }
        if (actualElem.getValue() == element) {
            elemBef = actualElem.getPrevElem();
            elemAft = actualElem.getNextElem();

            actualElem.getNextElem().prevElem = actualElem.getPrevElem();
            actualElem.getPrevElem().nextElem = actualElem.getNextElem();
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private static class Element<T> {
        private T value;
        private Element<T> nextElem;
        private Element<T> prevElem;

        public Element(T value) {
            this.value = value;
            nextElem = null;
            prevElem = null;
        }

        public T getValue() {
            return value;
        }

        public Element<T> getNextElem() {
            return nextElem;
        }

        public void setNextElem(Element<T> nextElem) {
            this.nextElem = nextElem;
        }

        public Element<T> getPrevElem() {
            return prevElem;
        }

        public void setPrevElem(Element<T> prevElem) {
            this.prevElem = prevElem;
        }

    }

}

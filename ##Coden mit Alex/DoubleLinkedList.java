import java.util.*;

public class DoubleLinkedList <T> implements Collection, List {
    private DoubleLinkedListElement <T> start;
    private DoubleLinkedListElement <T> end;
    private Integer size;

    public DoubleLinkedList() {
        size = 0;
        start = new DoubleLinkedListElement<>();
        end = new DoubleLinkedListElement<>();
        start.next = end;
        end.prev = start;
    }

    private class DoubleLinkedListElement <T> {
        private T value;
        private DoubleLinkedListElement next;
        private DoubleLinkedListElement prev;

        // Just because we can ;)
        DoubleLinkedListElement (T value, DoubleLinkedListElement prev, DoubleLinkedListElement next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        // prev -[ value ]- next // x - [ 5 ] - - [ 3 ] - x
        DoubleLinkedListElement(T value) {
            this(value, null, null);
        }

        DoubleLinkedListElement() {
            this(null);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public DoubleLinkedListElement getNext() {
            return next;
        }

        public void setNext(DoubleLinkedListElement next) {
            this.next = next;
        }

        public DoubleLinkedListElement getPrev() {
            return prev;
        }

        public void setPrev(DoubleLinkedListElement prev) {
            this.prev = prev;
        }
    }

    private class DoubleLinkedListIterator implements Iterator<T>, ListIterator<T> {
        private DoubleLinkedListElement current;
        private int index;

        DoubleLinkedListIterator() {
            current = start.next;
            index = 0;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T tmp = (T) current.getValue();
            current = current.next;
            index ++;
            return tmp;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            T tmp = (T) current.getValue();
            current = current.prev;
            index --;
            return tmp;
        }

        @Override
        public boolean hasNext() {
            return (current.getNext() != null);
        }

        @Override
        public boolean hasPrevious() {
            return (current.getPrev() != null);
        }

        @Override
        public int nextIndex() {
            return (index+1);
        }

        @Override
        public int previousIndex() {
            return (index-1);
        }

        @Override
        public void set(T t) {
            if (current == end || current == start)
                return;
            current.setValue(t);
        }

        @Override
        public void add(T t) {
            DoubleLinkedListElement<T> neu;
            neu = new DoubleLinkedListElement<>(t);

            neu.next = current.next;
            neu.prev = current;
            current.next =  neu;
            neu.next.prev = neu;

            DoubleLinkedList.this.size++;
        }

        @Override
        public void remove() {
            if (current == end || current == start)
                return;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current = current.next;
            DoubleLinkedList.this.size --;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        DoubleLinkedListElement current = start.next;

        while(current != end) {
            if (current.getValue().equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new DoubleLinkedListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        DoubleLinkedListElement<T> neu;
        try {
           neu = new DoubleLinkedListElement<>((T)o);
        } catch (Exception e) {
            return false;
        }

        neu.prev = end.prev;
        end.prev = neu;
        neu.next = end;
        neu.prev.next = neu;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        DoubleLinkedListElement current = start.next;

        while(current != end) {
            if (current.getValue().equals(o)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size --;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

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
        return new DoubleLinkedListIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        DoubleLinkedListIterator iterator = new DoubleLinkedListIterator();
        for (int i=0; i < index; i++) {
            iterator.next();
        }
        return iterator;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
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

    @Override
    public String toString() {
        // ToDo: Change to: "[ 10, 20, 30, 40 ]"
        return "DoubleLinkedList{" +
                "start=" + start +
                ", end=" + end +
                ", size=" + size +
                '}';
    }
}

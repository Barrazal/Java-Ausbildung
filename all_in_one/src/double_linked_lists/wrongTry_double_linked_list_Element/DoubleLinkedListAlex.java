package double_linked_lists.wrongTry_double_linked_list_Element;

import java.util.*;

public class DoubleLinkedListAlex<T> implements Collection, List {
    private DoubleLinkedListElement <T> start;
    private DoubleLinkedListElement <T> end;
    int size;

    public DoubleLinkedListAlex() {
        start = new DoubleLinkedListElement(null);
        end = new DoubleLinkedListElement(null);
        start.next = end;
        end.prev = start;
        size = 0;
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
        // Index exceeds size of list.
        if (index >= size) {
            return null;
        }

        DoubleLinkedListElement current = start.next;
        for (int i=0; i < index; i++) {
            current = current.next;
        }

        // current is on the position of the element we wish to remove
        current.next.prev = current.prev;
        current.prev.next = current.next;
        size--;
        return current;
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
        return size;
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
        return new DoubleLinkedListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    // Add element to the end of the list.
    @Override
    public boolean add(Object value) {
        DoubleLinkedListElement neu = new DoubleLinkedListElement(value);
        neu.next = end;
        neu.prev = end.prev;
        end.prev = neu;
        neu.prev.next = neu;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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

    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder();

        elements.append("[");
        DoubleLinkedListElement <T> current = start.next;
        while (current != end) {
            elements.append(current.getValue());
            if (current.next != end)
                elements.append(", ");
            current = current.next;
        }
        elements.append("]");
        return elements.toString();
    }

    private class DoubleLinkedListElement <T> {
        private T value;
        private DoubleLinkedListElement next;
        private DoubleLinkedListElement prev;

        public DoubleLinkedListElement(T value) {
            next = null;
            prev = null;
            this.value = value;
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

    private class DoubleLinkedListIterator <T> implements Iterator, ListIterator{
        DoubleLinkedListAlex<T>.DoubleLinkedListElement<T> cursor;
        int index;

        public DoubleLinkedListIterator () {
            cursor = (DoubleLinkedListAlex<T>.DoubleLinkedListElement<T>) start;
            index = -1;
        }

        @Override
        public boolean hasPrevious() {
            if (cursor.prev != start && cursor != start)
                return true;
            else
                return false;
        }

        @Override
        public T previous() {
            T value = null;
            if(hasPrevious()) {
                cursor = cursor.getPrev();
                value = cursor.getValue();
                index--;
            } else {
                throw new NoSuchElementException();
            }
            return value;
        }

        @Override
        public int nextIndex() {
            if (hasNext())
                return index+1;
            else
                return size();
        }

        @Override
        public int previousIndex() {
            if (hasPrevious())
                return index-1;
            else
                return -1;
        }

        @Override
        public boolean hasNext() {
            if (cursor.next != end && cursor != end)
                return true;
            else
                return false;
        }

        @Override
        public T next() {
            T value = null;
            if(hasNext()) {
                cursor = cursor.getNext();
                value = cursor.getValue();
                index++;
            } else {
                throw new NoSuchElementException();
            }
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(Object o) {
            throw new UnsupportedOperationException();
        }
    }


}

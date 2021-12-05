package double_linked_lists.genericList;

//In Java Collections, we use T for type, K for key and V for value.
public class GenericDoubleLinkedList<T> {
    private Element<T> start;
    private Element<T> end;
    private int size;

    public GenericDoubleLinkedList() {
        start = new Element<>(null);
        end = new Element<>(null);
        start.nextElem = end;
        end.prevElem = start;
        size = 0;
    }


    //it´s a way, but not the right way!
    public void add(T element) {
        Element<T> newElem = new Element<>(element);
        newElem.setPrevElem(start);
        newElem.getPrevElem().setNextElem(newElem);

        newElem.setNextElem(end);
        newElem.getNextElem().setPrevElem(newElem);
        size++;
    }

    //Fancy! it Works!
    public void add2(T element) {
        Element<T> newElem = new Element<>(element);
        Element<T> lastElem = end.prevElem;
        end.prevElem = newElem;
        newElem.setPrevElem(lastElem);
        newElem.setNextElem(end);
        lastElem.setNextElem(newElem);
        size++;
    }

    public void delete(T element) {
        Element<T> actualElem = start.getNextElem();
        Element<T> elemBef;
        Element<T> elemAft;
        while (actualElem.getValue() != element && actualElem.getNextElem() != null) {
            actualElem = actualElem.getNextElem();
        }
        if (actualElem.getValue() == element){
            elemBef = actualElem.getPrevElem();
            elemAft = actualElem.getNextElem();

            actualElem.getNextElem().prevElem = actualElem.getPrevElem();
            actualElem.getPrevElem().nextElem = actualElem.getNextElem();
            size--;
        }


    }

    public void print() {
        Element<T> currentNode = start;
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNextElem();
        }
    }

    public void print2() {
        Element<T> currentNode = start.getNextElem();
        while (currentNode.getNextElem() != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNextElem();
        }
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

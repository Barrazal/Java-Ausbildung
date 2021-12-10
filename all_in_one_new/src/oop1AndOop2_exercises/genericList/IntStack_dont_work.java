package oop1AndOop2_exercises.genericList;

// Java 07.1 exercise Java Stack
public class IntStack_dont_work<T> extends GenericDoubleLinkedList<T> {

    private T value;
    private final Integer maxInteger = 20;
    private GenericDoubleLinkedList<T> intStack;

    public IntStack_dont_work(T value) {
        this.value = value;
        this.intStack = intStack;
    }

    public IntStack_dont_work(GenericDoubleLinkedList<T> intStack) {
        this.intStack = intStack;
    }


    public void push(T element) throws StackTooSmallException {
        if (intStack.getSize() != maxInteger) {
            throw new StackTooSmallException();
        }
        intStack.add(element);
    }

    public void size() {
        System.out.printf("The Stack size is: %d \n", intStack.getSize());
    }

    public void pop() {
        GenericDoubleLinkedList<T> popElem;

        System.out.println(intStack.getEnd());
        intStack.removeLast();

    }
}



/*
Implementiere einen IntStack! Ein Stack ist ein Stapel, der immer die Dinge zuerst abarbeitet,
die er zuletzt bekommen hat nach dem Last in first out Prinzip. Die Klasse Stack sollte folgende Methoden haben:

    void push(int newElement)
        fügt ein neues Element oben in den Stack ein
    int size()
        gibt die Anzahl der Elemente im Stack zurück
    int pop()
        gibt das letzte Elemente des Stacks zurück und entfernt dieses vom Stack
    int peek()
        gibt das letzte Elemente des Stacks zurück ohne den Stack zu modifizieren
    int[] pop(int n)
        gibt die letzten n Elemente des Stacks zurück und entfernt diese vom Stack

Wird auf einen leeren Stack pop() oder peek() aufgerufen sollte eine StackTooSmallException geworfen werden.

Leg in der Main Methode einen Stack an und schreib ein paar Beispiel-Verwendungen. Vergiss nicht auf die Unittests!

 */

package oop1AndOop2_exercises.genericList;


public class IntStack<T> {
    private final static Integer maxInteger = 20;
    private GenericDoubleLinkedList<Integer> intStack = new GenericDoubleLinkedList<>("intStack");

    public void push(Integer input) throws StackTooSmallException {
        if (intStack.getSize() == maxInteger) {
            throw new StackTooSmallException();
        }
        intStack.add(input);
    }

    public void size() {
        System.out.printf("The Stack size is: %d\n", intStack.getSize());
    }

    public void pop() {
        GenericDoubleLinkedList.Element<Integer> lastElem = intStack.getEnd();
        System.out.printf("Output and delete the Element with the Value: '%d' from Stack\n", lastElem.getValue());
        intStack.removeLast();
    }

    public void peek() {
        GenericDoubleLinkedList.Element<Integer> lastElem = intStack.getEnd();
        System.out.println("The Last Value in the Stack is: " + lastElem.getValue());
    }

    public void pop(int n) {
        GenericDoubleLinkedList.Element<Integer> firstElem = intStack.getStart();
        GenericDoubleLinkedList<Integer> popArray = new GenericDoubleLinkedList<>();
        System.out.printf("Output and delete '%d' Elements from Stack: \n", n);
        int count = intStack.getSize() + 1;
        for (int i = 0; i < count; i++) {
            if (i >= count - n) {
                popArray.add(firstElem.getValue());
            }
            firstElem = firstElem.getNextElem();
        }
        for (int i = 0; i < n; i++) {
            intStack.removeLast();
        }
        popArray.print();
    }

}


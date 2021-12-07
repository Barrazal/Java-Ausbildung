/*
Implementiere einen IntQueue! Eine Queue ist eine Schlange, wie eine Warteschlange,
in der immer Elemente in der Reihenfolge abgearbeitet werden wie sie aufgenommen werden -
dem First in first out Prinzip. Die Klasse Queue sollte folgende Methoden haben:

    void enqueue(int newElement)
        fügt ein neues Element hinten in die Schlange ein
    int size()
        gibt die Anzahl der Elemente in der Queue zurück
    int dequeue()
        gibt das erste Elemente der Schlange zurück und entfernt dieses daraus
    int[] dequeue(int n)
        gibt die ersten n Elemente der Schlange zurück und entfernt diese daraus

Wird auf eine leere Queue dequeue() aufgerufen sollte eine QueueTooSmallException geworfen werden.

Leg in der Main Methode eine Queue an und schreib ein paar Beispiel-Verwendungen.
 */


package oop1AndOop2_exercises.genericList;

import java.util.ArrayList;

public class IntQueue {
    private ArrayList intQueue;

    
    public IntQueue(ArrayList intQueue) {
        this.intQueue = intQueue;
    }

    public void enqueue(int newElement){

    }
    public int size(){
        System.out.printf("The Stack size is: %d\n", intQueue.size());

    }

    public int dequeue(){

    }

    public int[] dequeue(int n){

    }


}

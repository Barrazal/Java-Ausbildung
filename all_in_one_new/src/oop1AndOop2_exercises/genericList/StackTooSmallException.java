package oop1AndOop2_exercises.genericList;

public class StackTooSmallException extends Exception {

    public StackTooSmallException() {
        System.out.println("Your Stack is Empty or not big enough! \n--StackTooSmallException--");
    }

    public StackTooSmallException(String s) {
        super(s);
    }

}


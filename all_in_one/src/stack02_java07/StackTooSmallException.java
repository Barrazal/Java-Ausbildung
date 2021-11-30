package stack02_java07;
public class StackTooSmallException extends Exception {

    public StackTooSmallException() {
        System.out.println("You need an bigger Stacksize! \n--StackTooSmallException--");
    }
}


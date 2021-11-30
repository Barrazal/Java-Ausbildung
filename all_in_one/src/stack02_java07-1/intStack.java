public class intStack {
    private final static Integer maxInteger = 10;
    private intObject firstInteger = null;
    private int size = -1;


    public void push(int newInt) throws StackTooSmallException {
        if (size == maxInteger) {
            throw new StackTooSmallException();
        }
    }

    public int size() {

    }

    public int pop() {


    }

    public int peek() {

    }

    public int[] pop(int value) {


    }


}


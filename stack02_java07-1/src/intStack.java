public class intStack {
    private final static Integer maxInteger = 10;
    private intObject firstInteger = null;
    private int size;


    public void push(int newInt) throws StackTooSmallException {
        if (size == maxInteger) {
            throw new StackTooSmallException();
        }


        intObject newObject = new intObject(newInt);
    }

    public int size() {
        return Size;
    }

    public int pop() {


    }

    public int peek() {

    }

    public int[] pop(int value) {


    }


}


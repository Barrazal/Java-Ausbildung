public class intObject {
    private int int1;
    private intObject nextInteger;

    public intObject(int int1, intObject nextInteger) {
        this.int1 = int1;
        this.nextInteger = nextInteger;
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public intObject getNextInteger() {
        return nextInteger;
    }

    public void setNextInteger(intObject nextInteger) {
        this.nextInteger = nextInteger;
    }
}

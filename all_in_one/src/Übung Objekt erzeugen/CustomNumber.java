public class CustomNumber {
    private static int result = 0;
    private static int number1 = 0;
    private static int number2 = 0;

    public CustomNumber(int num){
        this.number1 = num;
    }

    public static int add(int num){
        number2 = num;
        result = number1 + number2;
        return result;
    }

    public static int add(int num1, int num2) {
        number1 = num1;
        number2 = num2;
        result = number1 + number2;
        return result;
    }
}

public class Hauptprogramm {
    public static void main(String[] args) {
        System.out.println("#######Start Mainprogramm######");
        Person p1 = new Person("Haidinger", 30);
        p1.printPersonData();
        Person p2 = new Person();
        p2.printPersonData();
        System.out.println("###### End Main######");

        CustomNumber myNumber1 = new CustomNumber(3);
        System.out.println("CustomNumber " + myNumber1.add(4));           //Output: 7

        int result = CustomNumber.add(5, 6);
        System.out.println("result: " + result);             //Output: 11

    }
}


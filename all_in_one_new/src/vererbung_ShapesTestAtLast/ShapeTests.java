package vererbung_ShapesTestAtLast;

public class ShapeTests {
    public static void main(String[] args) throws IllegalArgumentException {
        Rectangle rect1 = new Rectangle();

        rect1.setRectSides(5.0,15.0);
        System.out.println(rect1.getArea());
        System.out.println(rect1.getPerimeter());

        Circle circ1 = new Circle();
        circ1.setRadius(14.3);
        System.out.println(circ1.getArea());
        System.out.println(circ1.getPerimeter());

        Square square1 = new Square(15.0);
        System.out.println(square1.getArea());
        System.out.println(square1.getPerimeter());


        square1.setSquareLength(30.0);
        System.out.println(square1.getArea());
        System.out.println(square1.getPerimeter());
        System.out.println(square1.getSquareLength());
        rect1.setRectSides(-35.059,58.6);

    }

}

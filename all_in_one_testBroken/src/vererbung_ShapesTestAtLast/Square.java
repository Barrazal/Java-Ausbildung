package vererbung_ShapesTestAtLast;

public class Square extends Rectangle{
    private Double length;

    public Square() {
        super();
    }

    public Square(Double length) throws IllegalArgumentException {
    this.length = length;
    this.setRectSides(length,length);

    }

    public Double getSquareLength() {
        return length;
    }

    public void setSquareLength(Double length) throws IllegalArgumentException {
        this.length = length;
        this.setRectSides(length,length);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }
}

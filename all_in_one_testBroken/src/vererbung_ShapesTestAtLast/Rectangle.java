package vererbung_ShapesTestAtLast;

public class Rectangle extends AbstractShapes {


    private Double width;
    private Double length;

    public Rectangle() {
        width = null;
        length = null;
    }

    public Rectangle(Double width, Double length) throws IllegalArgumentException {
        if (width <=0 || length <=0){
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.length = length;
    }

    public Double getRectWidth() {
        return width;
    }

    public void setRectWidth(Double width) throws IllegalArgumentException {
        if (width <=0 || length <=0){
            throw new IllegalArgumentException();
        }
        this.width = width;
    }

    public Double getRectLength() {
        return length;
    }

    public void setRectLength(Double length) throws IllegalArgumentException {
        if (width <=0 || length <=0){
            throw new IllegalArgumentException();
        }
        this.length = length;
    }
    public void setRectSides(Double width, Double length) throws IllegalArgumentException {
        if (width <=0 || length <=0){
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        Double area = width * length;

        return area;
    }

    @Override
    public double getPerimeter() {
        Double perimeter = 2 * (width + length);
        return perimeter;
    }
}

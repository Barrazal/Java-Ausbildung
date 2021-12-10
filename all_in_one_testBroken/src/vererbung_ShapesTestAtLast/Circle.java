package vererbung_ShapesTestAtLast;

public class Circle extends AbstractShapes {
    private Double radius;
    private Double area = null;
    private Double perimeter=null;

    public Circle(Double radius) throws IllegalArgumentException {
        if (radius <=0 || radius <=0){
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }

    public Circle() {
        this.radius = null;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) throws IllegalArgumentException {
        if (radius <=0 || radius <=0){
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        area = Math.PI * Math.pow(radius,2);
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = 2* Math.PI * radius;
        return perimeter;
    }
}

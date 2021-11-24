package MyVehicles;

public class ElectroScooter {
    private String id;
    private Double horsePower;
    private Integer mileage;
    private Double price;
    private Integer speed;
    private ScooterBrand brand;
    private static Integer counter = 0;

    public ElectroScooter(String id, Double horsePower, Integer mileage, Double price, Integer speed, ScooterBrand brand) {
        this.id = id;
        this.horsePower = horsePower;
        this.mileage = mileage;
        this.price = price;
        this.speed = speed;
        this.brand = brand;
        counter++;
    }

    public ElectroScooter() {
        this("N/A", 0.0, 0, 0.0, 0, ScooterBrand.NONE);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Double horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        setMileage(mileage, false);
    }

    public void setMileage(Integer mileage, Boolean override) {
        if (mileage < 0) {
            System.out.println("Error: Negative milage provided!\nMilage unchanged!");
            return;
        }

        if (mileage < this.mileage && !override) {
            System.out.println("Error: Resetting Milage is prohibited by Law!");
            return;
        }

        if (override) {
            System.out.println("Notice: Changes have been logged to official logs.");
        }

        this.mileage = mileage;
    }

    // ToDo: Make setters more secure / sane e.g. prohibiting negative values where appropriate.
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public ScooterBrand getBrand() {
        return brand;
    }

    public void setBrand(ScooterBrand brand) {
        this.brand = brand;
    }

    public static Integer getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Scooter: (" + brand + ") " +
                "id='" + id + '\'' +
                ", horsePower=" + horsePower +
                ", mileage=" + mileage +
                ", price=" + price +
                ", speed=" + speed;
    }
}

abstract class Vehicle {
    private String brand;
    private double speed;
    private String id;
    private int mileage;
    private boolean rented;

    public Vehicle(String id, String brand, double speed) {
        this.id = id;
        this.brand = brand;
        this.speed = speed;
        this.mileage = 0;
        this.rented = false; // Implicit nu este închiriată
    }


    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public String getId() { return id; }
    public int getMileage() { return mileage; }
    public boolean isRented() { return rented; }

    public void rent() {
        if (this.rented) throw new RuntimeException("Vehiculul " + id + " este deja închiriat!");
        this.rented = true;
    }

    // Metodă abstractă ce va fi implementată de copii
    public abstract void move();

    public void returnVehicle(int drivenKm) {
        if (!this.rented) {
            throw new RuntimeException("Eroare: Vehiculul " + id + " nu este închiriat!");
        }
        if (drivenKm <= 0) {
            throw new RuntimeException("Eroare: Kilometrii parcurși trebuie să fie > 0!");
        }
        this.mileage += drivenKm;
        this.rented = false;
        System.out.println("Vehiculul " + id + " a fost returnat. Kilometraj nou: " + mileage);
    }

    // Metode abstracte noi
    public abstract boolean needsService();
    public abstract double rentalPrice(int days);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle car = (Vehicle) obj;
        return Double.compare(car.getSpeed(), getSpeed()) == 0 && getBrand().equals(car.getBrand());
    }
}

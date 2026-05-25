class Car extends Vehicle {
    private int doors;

    public Car(String id, String brand, double speed, int doors) {
        super(id, brand, speed);
        this.doors = doors;
    }

    @Override
    public void move() {
        System.out.println("Mașina " + getBrand() + " rulează pe șosea cu " + getSpeed() + " km/h.");
    }

    // Compararea a două mașini prin overriding .equals()

    @Override
    public boolean needsService() {
        return getMileage() > 10000; // Mașinile au nevoie de service la 10k km
    }
//Car: 50 * days, +10% if doors ≥ 4
    @Override
    public double rentalPrice(int days) {
        if (this.doors>=4)
        return days * 50.0*1.1;
        else {return days * 50.0;}// 50€ pe zi
    }
}




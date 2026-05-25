class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String id, String brand, double speed, boolean hasSidecar) {
        super(id, brand, speed);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void move() {
        System.out.println("Motocicleta " + getBrand() + " face slalom în trafic la " + getSpeed() + " km/h.");
    }
    @Override
    public boolean needsService() {
        return getMileage() > 5000; // Motocicletele au nevoie de service mai des
    }

    @Override
    public double rentalPrice(int days) {
        if(hasSidecar)
        return days * 30.0+15.0 * days;
        else{return days * 30.0;} // 30€ pe zi
    }
}

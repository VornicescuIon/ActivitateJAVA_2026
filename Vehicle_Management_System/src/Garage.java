class Garage {
    private Vehicle[] fleet;
    private int size = 0;

    public Garage(int capacity) {
        fleet = new Vehicle[capacity];
    }

    public void add(Vehicle v) {
        if (size >= fleet.length) {
            System.out.println("Garajul este plin!");
            return;
        }
        if (findById(v.getId()) != null) {
            System.out.println("Eroare: ID duplicat " + v.getId());
            return;
        }
        fleet[size++] = v;
        System.out.println("Adăugat: " + v.getBrand() + " [" + v.getId() + "]");
    }

    public Vehicle findById(String id) {
        for (int i = 0; i < size; i++) {
            if (fleet[i].getId().equals(id)) return fleet[i];
        }
        return null;
    }

    public void rentById(String id) {
        Vehicle v = findById(id);
        if (v != null) {
            try { v.rent(); System.out.println("Închiriat cu succes: " + id); }
            catch (Exception e) { System.out.println(e.getMessage()); }
        } else System.out.println("Vehiculul nu a fost găsit.");
    }

    public void returnById(String id, int drivenKm) {
        Vehicle v = findById(id);
        if (v != null) {
            try { v.returnVehicle(drivenKm); }
            catch (Exception e) { System.out.println(e.getMessage()); }
        }
    }

    public void printAvailable() {
        System.out.println("\n--- Vehicule Disponibile ---");
        for (int i = 0; i < size; i++) {
            if (!fleet[i].isRented()) System.out.println(fleet[i].getId() + " - " + fleet[i].getBrand());
        }
    }

    public void printNeedsService() {
        System.out.println("\n--- Vehicule care necesită Service ---");
        for (int i = 0; i < size; i++) {
            if (fleet[i].needsService()) System.out.println(fleet[i].getId() + " (" + fleet[i].getMileage() + " km)");
        }
    }

    public void printRentalEstimate(String id, int days) {
        Vehicle v = findById(id);
        if (v != null) System.out.println("Preț estimat pt " + id + " (" + days + " zile): " + v.rentalPrice(days) + " EUR");
    }
}

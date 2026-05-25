public class Main {
    public static void main(String[] args) {
        Garage myGarage = new Garage(10);

        // Adăugare vehicule
        myGarage.add(new Car("B-01-CAR", "Toyota Corolla", 180, 4));
        myGarage.add(new Car("B-02-CAR", "Mazda MX-5", 200, 2));
        myGarage.add(new Motorcycle("B-03-MOT", "Honda Rebel", 140, false));
        myGarage.add(new Motorcycle("B-04-MOT", "Ural Ranger", 110, true));
        myGarage.add(new Truck("B-05-TRK", "Volvo FH16", 90, 20000));

        // Închiriere
        System.out.println("\n--- Acțiuni ---");
        myGarage.rentById("B-01-CAR");
        myGarage.rentById("B-04-MOT");

        // Afișare stare
        myGarage.printAvailable();
        myGarage.printRentalEstimate("B-05-TRK", 5);

        // Returnare cu km mulți pentru a declanșa service-ul
        myGarage.returnById("B-01-CAR", 12000);
        myGarage.printNeedsService();

        System.out.println("\n--- Comparare Mașini ---");
        Car car1 = new Car("1","Dacia Logan", 90,1);
        Car car2 = new Car("2","Dacia Logan", 90,5);
        Car car3 = new Car("3","BMW M4", 200,4);

        System.out.println("Este car1 egal cu car2? " + car1.equals(car2));
        System.out.println("Este car1 egal cu car3? " + car1.equals(car3));
    }
}
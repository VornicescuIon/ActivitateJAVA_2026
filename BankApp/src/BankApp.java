import clase.*;

public class BankApp {
    public static void main(String[] args) {
        System.out.println("=== Sistem Bancar ===");
        
        try {
            SavingsAccount account = new SavingsAccount("Popescu", "Ion", 123456789, 1000.0, 5.0);
            System.out.println("Cont creat pentru: " + account.getNume() + " " + account.getPrenume() + ", Sold initial: " + account.getSold());

            account.deposit(500.0);
            System.out.println("Dupa depunere (500), sold: " + account.getSold());

            account.withdraw(200.0);
            System.out.println("Dupa retragere (200), sold: " + account.getSold());
            
            account.applyInterest();
            System.out.println("Dupa aplicarea dobanzii (5%), sold: " + account.getSold());

            System.out.println("\nIncercare retragere suma prea mare (2000)...");
            account.withdraw(2000.0); // Acest apel va arunca o exceptie

        } catch (InsufficientFundsException | InvalidAmountException e) {
            System.out.println("Eroare operatiune: " + e.getMessage());
        }

        try {
            BankAccount account2 = new BankAccount("Ionescu", "Ana", 987654321, 500.0);
            System.out.println("\nIncercare depunere suma invalida (-100)...");
            account2.deposit(-100.0); // Acest apel va arunca o exceptie
            
        } catch (InvalidAmountException e) {
            System.out.println("Eroare operatiune: " + e.getMessage());
        }
    }
}
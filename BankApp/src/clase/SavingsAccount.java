package clase;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String nume, String prenume, int cnp, double sold, double interestRate) {
        super(nume, prenume, cnp, sold);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = this.sold * (this.interestRate / 100);
        this.sold += interest;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}

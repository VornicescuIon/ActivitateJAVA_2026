package clase;

public class BankAccount {
    private String nume;
    private String prenume;
    private int cnp;
    protected double sold;

    public BankAccount(String nume, String prenume, int cnp, double sold) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.sold = sold;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Suma pentru depunere trebuie sa fie pozitiva.");
        }
        this.sold += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Suma pentru retragere trebuie sa fie pozitiva.");
        }
        if (amount > this.sold) {
            throw new InsufficientFundsException("Fonduri insuficiente! Sold curent: " + this.sold);
        }
        this.sold -= amount;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }
}

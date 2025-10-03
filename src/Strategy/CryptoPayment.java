package Strategy;

public class CryptoPayment implements PaymenStrategy {

    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pagado $" + amount + "con Ciptomonedas (" + walletAddress + ")");
    }
}

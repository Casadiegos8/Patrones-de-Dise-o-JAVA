package Strategy;

public class PayPalPayment implements PaymenStrategy {

    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pagado $" + amount + "con PayPal (" + email + ")");
    }
}

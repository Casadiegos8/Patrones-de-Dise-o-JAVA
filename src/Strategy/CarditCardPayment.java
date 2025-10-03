package Strategy;

public class CarditCardPayment implements PaymenStrategy {


    private String cardNumber;
    private String name;

    public CarditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pago $" + amount + "con tarjeta de credito (" + cardNumber + ")");
    }
}

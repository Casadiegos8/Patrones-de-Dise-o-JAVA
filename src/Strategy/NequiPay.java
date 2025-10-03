package Strategy;

public class NequiPay implements PaymenStrategy {
    private String numberPhone;

    public NequiPay(String numberPhone) {
        this.numberPhone = numberPhone;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Pago $" + amount + "numero de nequi (" + numberPhone + ")");
    }
}

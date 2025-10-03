package Strategy;

public class ShoppingCart {

    /*Patron de diseño singleton*/
    private static ShoppingCart shoppingCart = null;
    public static ShoppingCart getInstance() {
        if (shoppingCart == null) {
             shoppingCart =  new ShoppingCart();
        }
        return shoppingCart;
    }

    private PaymenStrategy paymenStrategy;

    public void setPaymenStrategy(PaymenStrategy paymenStrategy) {
        this.paymenStrategy = paymenStrategy;
    }

    public void checOut(double amount) {
        if (paymenStrategy == null) {
            System.out.println("Por favor, selecciones un metodo de pago");
        }
        assert paymenStrategy != null;
        paymenStrategy.pay(amount);
    }
}

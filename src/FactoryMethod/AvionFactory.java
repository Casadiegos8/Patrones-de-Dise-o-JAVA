package FactoryMethod;

public class AvionFactory implements Transporte {
    @Override
    public void entregar() {
        System.out.println("Entregado por avion");
    }
}

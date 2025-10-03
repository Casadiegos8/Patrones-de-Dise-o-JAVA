package FactoryMethod;

public class CamionFactory implements Transporte {
    @Override
    public void entregar() {
        System.out.println("Entregado por camion");
    }
}

package FactoryMethod;

public class BarcoFactory implements Transporte{
    @Override
    public void entregar() {
        System.out.println("Entregado por Barco");
    }
}

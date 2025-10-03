package FactoryMethod;

public class LogisticaBarco extends Logistica {
    @Override
    public Transporte crearTransporte() {
        return new BarcoFactory();
    }
}

package FactoryMethod;

public class LogisticaAvion extends Logistica {
    @Override
    public Transporte crearTransporte() {
        return new AvionFactory();
    }
}

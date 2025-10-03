package FactoryMethod;

public class LogisticaTerrestre extends Logistica{
    @Override
    public Transporte crearTransporte() {
        return new CamionFactory();
    }
}

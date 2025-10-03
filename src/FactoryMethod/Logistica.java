package FactoryMethod;

public abstract class Logistica {
    //Factory Method
    public abstract Transporte crearTransporte();
    //Metodo que usa el producto (logistica de negoocio)
    public void panificarEntrega() {
        Transporte transporte = crearTransporte();
        System.out.println("Planificando entrega... ");
        transporte.entregar();
    }
}

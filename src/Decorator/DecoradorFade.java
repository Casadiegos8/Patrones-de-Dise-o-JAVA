package Decorator;

public abstract class DecoradorFade implements Cafe {
    protected Cafe cafeDecorador;

    public DecoradorFade(Cafe cafeDecorador) {
        this.cafeDecorador = cafeDecorador;
    }
    @Override
    public String getDescription() {
        return cafeDecorador.getDescription();
    }

    @Override
    public double getCosto() {
        return cafeDecorador.getCosto();
    }
}

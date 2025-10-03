package Decorator;

public class LecheDecorator extends DecoradorFade {
    public LecheDecorator(Cafe cafeDecorador) {
        super(cafeDecorador);
    }
    @Override
    public String getDescription() {
        return cafeDecorador.getDescription() + ", leche";
    }

    @Override
    public double getCosto() {
        return cafeDecorador.getCosto()  + 2.0;
    }
}

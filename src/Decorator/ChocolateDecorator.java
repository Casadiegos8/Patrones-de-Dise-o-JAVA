package Decorator;

public class ChocolateDecorator extends DecoradorFade{
    public ChocolateDecorator(Cafe cafeDecorador) {
        super(cafeDecorador);
    }
    @Override
    public String getDescription() {
        return cafeDecorador.getDescription() + ", chocolate";
    }

    @Override
    public double getCosto() {
        return cafeDecorador.getCosto() + 3.0;
    }
}

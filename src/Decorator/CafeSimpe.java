package Decorator;

public class CafeSimpe implements Cafe {
    @Override
    public String getDescription() {
        return "simple";
    }

    @Override
    public double getCosto() {
        return 5.0f;
    }
}

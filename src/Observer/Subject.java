package Observer;

public interface Subject {
    void subcribe(Observer observer, String name);
    void unSubcribe(Observer observer);
    void notifyObservers();
}

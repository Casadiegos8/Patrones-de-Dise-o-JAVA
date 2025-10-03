package Observer;

import java.util.ArrayList;
import java.util.List;

public class NewAgency implements Subject {

    private static List<Observer> observers = new ArrayList<>();
    private static List<String> nameChanel = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
    public static int sendSizeList() {
        int total = observers.size();
        return total;
    }
    public static List<String> getChanles() {
        return nameChanel;
    }
    public static List<Observer> getObservers() {
        return observers;
    }
    @Override
    public void subcribe(Observer observer, String name) {
        observers.add(observer);
        nameChanel.add(name);
    }

    @Override
    public void unSubcribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer :observers) {
            observer.update(news);
        }
    }
}

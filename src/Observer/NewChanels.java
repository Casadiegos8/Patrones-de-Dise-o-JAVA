package Observer;

public class NewChanels implements Observer {
    private String name;
    private String lestName;

    public NewChanels(String name) {
        this.name = name;
    }


    @Override
    public void update(String message) {
        this.lestName = message;
        dispaly();
    }
    public void dispaly() {
        System.out.println("[" + name + "] noticias: " + lestName);
    }
}

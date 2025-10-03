
import Decorator.Cafe;
import Decorator.CafeSimpe;
import Decorator.ChocolateDecorator;
import Decorator.LecheDecorator;
import FactoryMethod.Logistica;
import FactoryMethod.LogisticaAvion;
import FactoryMethod.LogisticaBarco;
import FactoryMethod.LogisticaTerrestre;
import Observer.Observer;
import Strategy.*;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Observer.NewAgency;
import Observer.NewChanels;
public class Main {


    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        try {
            System.out.println("Patrones de diseño");
            System.out.println("Elige un patron de diseño");
            System.out.println("1. Estrategy");
            System.out.println("2. Observable");
            System.out.println("3. Factory");
            System.out.println("4. Decorator");
            System.out.println("5. Salir");


            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    patronStrategy();
                case 2:
                    patronObservable();
                case 3:
                    patronFactory(sc);
                case 4:
                    patronDecorator(sc);
                case 5:
                    System.out.println("Saliendo....");
                    break;

            }
        } catch (Exception e) {
            System.out.println("Error ingrese un numero");
            menu();
        }

    }

    private static void patronDecorator(Scanner sc) {
        System.out.println("Eliga la opcion de cafe que quiere pedir");
        System.out.println("1. cafe simple ");
        System.out.println("2. cafe con leche ");
        System.out.println("3. chocolate ");
        System.out.println("4. Salir");

        int opcion = sc.nextInt();

        if (opcion == 1) {
            Cafe cafe1 = new CafeSimpe();
            System.out.println("Descripcion: " + cafe1.getDescription());
            System.out.println("Costo: " + cafe1.getCosto());
            patronDecorator(sc);
        } else if (opcion == 2) {
            Cafe cafe2 = new LecheDecorator(new CafeSimpe());
            System.out.println("Descripcion: " + cafe2.getDescription());
            System.out.println("Costo: " + cafe2.getCosto());
            patronDecorator(sc);
        } else if (opcion == 3) {
            Cafe cafe3 = new ChocolateDecorator(new LecheDecorator(new CafeSimpe()));
            System.out.println("Descripcion: " + cafe3.getDescription());
            System.out.println("Costo: " + cafe3.getCosto());
            patronDecorator(sc);
        }
        else {menu();}
    }

    private static void patronFactory(Scanner sc) {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
        System.out.println("=== ENTREGAS LOGÍSTICAS ===");
        System.out.println("Eliga el metodo de entrega");
        System.out.println("1. Avion");
        System.out.println("2. Barco");
        System.out.println("4. Camion");
        int opcion = sc.nextInt();
        entrega(opcion, sc);

    }

    private static void entrega(int opcion, Scanner sc) {
        if (opcion == 1) {
            Logistica avion = new LogisticaAvion();
            avion.panificarEntrega(); // AvionFactory
            menu();
        } else if (opcion == 2) {
            Logistica barco = new LogisticaBarco();
            barco.panificarEntrega(); // BarcoFactory
            menu();
        } else if (opcion == 3) {
            Logistica camion = new LogisticaTerrestre();
            camion.panificarEntrega(); // CamionFactory
            menu();
        } else {
            System.out.println("Opcion no valida");
            patronFactory(sc);
        }

    }

    public static void patronObservable() {
        try {
            Scanner sc = new Scanner(System.in);
            NewAgency agency = new NewAgency();
            System.out.println("Agencia de canales de noticias");
            System.out.println("Opciones");
            System.out.println("1. Agregar canales");
            System.out.println("2. Eliminar canales");
            System.out.println("3. Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    registerChanels(agency);
                case 2:
                    deleteChanels(agency);
                case 3:
                    menu();
            }
        } catch (Exception e) {
            System.out.println("Error ingrese un numero");
            menu();
        }

    }

    private static void deleteChanels(NewAgency agency) {
        Scanner sc = new Scanner(System.in);
        List<String> listChanel;
        listChanel =  NewAgency.getChanles();
        System.out.println("Lista de canalaes");
        for (int i = 0 ; i < listChanel.size(); i++) {
            System.out.println( i + "." + " " + listChanel.get(i));
        }
        System.out.println("Eliga el numero de canal a eliminar");
        int chanelRemove = sc.nextInt();
        List<Observer> listChanelRemove = NewAgency.getObservers();
        System.out.println("Cargando");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            for (int i = 0; i<listChanelRemove.size(); i++) {
                if (i == chanelRemove) {
                    listChanel.remove(chanelRemove);
                    agency.unSubcribe(listChanelRemove.get(i));
                    System.out.println("TOTAL DE CANALES"+ " " + listChanelRemove.size());
                    patronObservable();
                }
            }
        });
        executor.shutdown();
    }

    public static void registerChanels(NewAgency agency) {
        int i = 1;
        Scanner sc = new Scanner(System.in);
        NewChanels chanel;

        System.out.println("Ingrese los canalaes que quiere registrar");
        int totalCanales = sc.nextInt();
        sc.nextLine();
        while (true) {
            System.out.println("Ingres el canal: " + i);
            String chanelAdd = sc.nextLine();
            chanel = new NewChanels(chanelAdd);
            agency.subcribe(chanel, chanelAdd);
            i++;
            if (i > totalCanales) {
                System.out.println("Total de canales"  + " " + NewAgency.sendSizeList());
                sendNotify(agency);
                break;
            }
        }
    }
    public static void sendNotify(NewAgency agency) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Primer despacho de noticias ===");
        System.out.println("Inregse la notica que quiere notificar");
        String news = sc.next();
        agency.setNews(news);
    }
    public static void patronStrategy() {
        ShoppingCart cart = ShoppingCart.getInstance();
        System.out.println("Por favor elige el metodo de pago");
        System.out.println("1. PayPal");
        System.out.println("2. Tarjeta de credito");
        System.out.println("3. Cryptomoneda");
        System.out.println("4. Nequi");
        System.out.println("5. Salir");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el numero de la tarjeta");
                String cardNumber = sc.next();
                System.out.println("Ingrese el correo del propietario");
                String correo = sc.next();
                System.out.println("Ingrese el monto");
                float amuntPayPal = sc.nextFloat();
                payPayPal(cardNumber, correo, amuntPayPal, cart);
            case 2:
                System.out.println("Ingrese el numero de la tarjeta");
                String cardNumber2 = sc.next();
                System.out.println("Ingrese el nombre del propietario");
                String name = sc.next();
                System.out.println("Ingrese el monto");
                float amuntCard = sc.nextFloat();
                cardPay(cardNumber2, name, amuntCard, cart);
            case 3:
                System.out.println("Ingrese el addres del la crypto");
                String wallet = sc.next();
                System.out.println("Ingrese el monto");
                float amount = sc.nextFloat();
                cyptoPay(wallet, amount, cart);
            case 4:
                System.out.println("Ingrese el numero de nequi");
                String nequi = sc.next();
                System.out.println("Ingrese el monto");
                float amountNequi = sc.nextFloat();
                cartNequi(nequi, amountNequi, cart);
            case 5:
                menu();

        }
    }

    private static void cartNequi(String nequi, float amountNequi, ShoppingCart cart) {
        if (!nequi.isEmpty() && amountNequi != 0) {
         cart.setPaymenStrategy(new NequiPay(nequi));
         cart.checOut(amountNequi);
        } else {
            System.out.println("Por favor, complete todos los campos");
            patronStrategy();
        }
    }

    public static void payPayPal(String cardNUmber, String correo, float amount, ShoppingCart cart) {
        if (!cardNUmber.isEmpty()) {
            cart.setPaymenStrategy(new PayPalPayment(correo));
            cart.checOut(amount);
            patronStrategy();
        } else {
            System.out.println("Por favor, complete todos los campos");
            patronStrategy();
        }
    }
    public static void cardPay(String cardNumber, String name, float amount, ShoppingCart cart) {
        if (!cardNumber.isEmpty() && !name.isEmpty() && amount != 0) {
            cart.setPaymenStrategy(new CarditCardPayment(name, cardNumber));
            cart.checOut(amount);
            patronStrategy();
        } else {
            System.out.println("Por favor, complete todos los campos");
            patronStrategy();
        }
    }
    public static void cyptoPay(String address, float amount, ShoppingCart cart) {
        if (!address.isEmpty() && amount != 0){
            cart.setPaymenStrategy(new CryptoPayment(address));
            cart.checOut(amount);
            patronStrategy();
        } else {
            System.out.println("Por favor, complete todos los campos");
            patronStrategy();
        }
    }
}
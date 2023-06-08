import java.util.Scanner;

public class SweetThingy {
    private final String type;
    private final String name;
    private final int chocolatePercentage;
    private final int price;
    private final double weight;

    static Scanner scanner = new Scanner(System.in);

    public SweetThingy(String type, String name, int chocolatePercentage, int price, double weight){
        this.type = type;
        this.name = name;
        this.chocolatePercentage = chocolatePercentage;
        this.price = price;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getChocolatePercentage() {
        return chocolatePercentage;
    }

    public int getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public static void printSweetThingy(SweetThingy sweetThingy){
        System.out.println("Тип: " + sweetThingy.getType() + "; Назва: " + sweetThingy.getName() + "; Відсоток шоколаду: " + sweetThingy.getChocolatePercentage() + "%; Ціна за кілограм: " + sweetThingy.getPrice() + "грн/кг; Вага: " + sweetThingy.getWeight() + "кг.");
    }
}

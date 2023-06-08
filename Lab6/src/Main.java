import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean isSortingValue(String value){
        return value.toLowerCase().contains("type") || value.toLowerCase().contains("name") || value.toLowerCase().contains("chocolate percentage") || value.toLowerCase().contains("price") || value.toLowerCase().contains("weight");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("C13 = " + 2224 % 13 + " - Визначити ієрархію цукерок та інших солодощів. Створити кілька об'єктів-цукерок. Зібрати дитячий подарунок з визначенням його ваги. Провести сортування цукерок у подарунку за одним із параметрів. Знайти цукерку в подарунку, що відповідає заданому діапазону вмісту шоколаду в цукерці.");

        List<SweetThingy> partySweets = new ArrayList<>();
        Comparator<SweetThingy> comparator;

        partySweets.add(new Candie("Рафаелло", 0, 400, 0.25));
        partySweets.add(new Candie("Ліщинка", 23, 150, 0.4));
        partySweets.add(new Cake("Київський", 40, 300, 2));
        partySweets.add(new Cookie("Есмеральда", 30, 200, 0.3));
        partySweets.add(new Cookie("До кави", 0, 80, 0.5));
        partySweets.add(new IceCream("Ваніль", 70, 1.5));
        partySweets.add(new IceCream("Полуниця", 90, 0.5));
        partySweets.add(new IceCream("Банан", 85, 0.5));

        double weight = 0;
        for (SweetThingy sweetThingy : partySweets) {
            weight += sweetThingy.getWeight();
        }

        System.out.println("Вага подарунку: " + weight);

        String sortingValue = "";
        while (!isSortingValue(sortingValue)){
            System.out.print("Введіть поле за яким відбудеться сортування: ");
            sortingValue = scanner.next();
        }

        String wayOfSorting = "";
        while (!wayOfSorting.contains("asc") && !wayOfSorting.contains("desc")){
            System.out.print("Введіть напрямок за яким відбудеться сортування: ");
            wayOfSorting = scanner.next();
        }


        if(sortingValue.contains("type")){
            comparator = Comparator.comparing(SweetThingy::getType);
        }
        else if(sortingValue.contains("name")){
            comparator = Comparator.comparing(SweetThingy::getName);
        }
        else if(sortingValue.contains("chocolate percentage")){
            comparator = Comparator.comparingInt(SweetThingy::getChocolatePercentage);
        }
        else if(sortingValue.contains("price")){
            comparator = Comparator.comparingInt(SweetThingy::getPrice);
        }
        else{
            comparator = Comparator.comparingDouble(SweetThingy::getWeight);
        }

        if(wayOfSorting.contains("desc")){
            comparator.reversed();
        }

        partySweets.sort(comparator);

        for (SweetThingy sweetThingy : partySweets){
            SweetThingy.printSweetThingy(sweetThingy);
        }

        int minRange;
        System.out.print("Введіть меншу границю відсотку шоколаду: ");
        minRange = scanner.nextInt();

        int maxRange;
        System.out.print("Введіть більшу границю відсотку шоколаду: ");
        maxRange = scanner.nextInt();

        System.out.println("Солодощі, які входять в вибрані межі: ");

        for (SweetThingy sweetThingy : partySweets){
            if (sweetThingy.getChocolatePercentage() >= minRange && sweetThingy.getChocolatePercentage() <= maxRange){
                SweetThingy.printSweetThingy(sweetThingy);
            }
        }
    }
}
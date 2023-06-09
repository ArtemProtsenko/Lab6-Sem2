import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean isSortingValue(String value){ // Булеан для перевірки чи є змінна величиною за якою може відбуватися сортування.
        return value.toLowerCase().contains("type") || value.toLowerCase().contains("name") || value.toLowerCase().contains("chocolate percentage") || value.toLowerCase().contains("price") || value.toLowerCase().contains("weight");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("C13 = " + 2224 % 13 + " - Визначити ієрархію цукерок та інших солодощів. Створити кілька об'єктів-цукерок. Зібрати дитячий подарунок з визначенням його ваги. Провести сортування цукерок у подарунку за одним із параметрів. Знайти цукерку в подарунку, що відповідає заданому діапазону вмісту шоколаду в цукерці.");

        List<SweetThingy> partySweets = new ArrayList<>();
        Comparator<SweetThingy> comparator;

        partySweets.add(new Candie("Рафаелло", 0, 400, 0.25)); // Заповнення ліста солодощів для подарунку.
        partySweets.add(new Candie("Ліщинка", 23, 150, 0.4));
        partySweets.add(new Cake("Київський", 40, 300, 2));
        partySweets.add(new Cookie("Есмеральда", 30, 200, 0.3));
        partySweets.add(new Cookie("До кави", 0, 80, 0.5));
        partySweets.add(new IceCream("Ваніль", 70, 1.5));
        partySweets.add(new IceCream("Полуниця", 90, 0.5));
        partySweets.add(new IceCream("Банан", 85, 0.5));

        double weight = 0;
        for (SweetThingy sweetThingy : partySweets) {
            weight += sweetThingy.getWeight(); // Знаходження маси подарунку.
        }

        System.out.println("Вага подарунку: " + weight); // Виведення маси подарунку.

        String sortingValue = "";
        while (!isSortingValue(sortingValue)){
            System.out.print("Введіть поле за яким відбудеться сортування: "); // Введення поля за яким буде відбуватися сортування.
            sortingValue = scanner.next();
        }

        String wayOfSorting = "";
        while (!wayOfSorting.contains("asc") && !wayOfSorting.contains("desc")){
            System.out.print("Введіть напрямок за яким відбудеться сортування: "); // Введення напрямку сортування.
            wayOfSorting = scanner.next();
        }


        if(sortingValue.contains("type")){ // Заповнення компаратору. Те за яким полем буде відбуватися сортування.
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

        if(wayOfSorting.contains("desc")){ // Напрямок сортування.
            comparator.reversed();
        }

        partySweets.sort(comparator); // Сортування.

        for (SweetThingy sweetThingy : partySweets){ // Виведення відсортованого ліста.
            SweetThingy.printSweetThingy(sweetThingy);
        }

        int minRange;
        System.out.print("Введіть меншу границю відсотку шоколаду: "); // Введення границі відсотку шоколаду для знаходження відповідних солодощів.
        minRange = scanner.nextInt();

        int maxRange;
        System.out.print("Введіть більшу границю відсотку шоколаду: ");
        maxRange = scanner.nextInt();

        System.out.println("Солодощі, які входять в вибрані межі: ");

        for (SweetThingy sweetThingy : partySweets){
            if (sweetThingy.getChocolatePercentage() >= minRange && sweetThingy.getChocolatePercentage() <= maxRange){ // Перевірка чи відсоток шоколаду входить в задані межі.
                SweetThingy.printSweetThingy(sweetThingy); // Виведення знайдених солодощів.
            }
        }
    }
}
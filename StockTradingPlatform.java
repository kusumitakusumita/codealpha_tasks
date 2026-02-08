package codealpha_tasks;
import java.util.Scanner;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class User {
    String name;
    int shares;

    User(String name) {
        this.name = name;
        this.shares = 0;
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);//to take input from the user

        Stock stock = new Stock("TCS", 3500);
        User user = new User("Investor");

        int choice;

        do {
            System.out.println("\n--- Stock Trading Platform ---");
            System.out.println("1. View Stock");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(stock.name + " Price: Rs" + stock.price);
                    break;

                case 2:
                    System.out.print("Enter shares to buy: ");
                    int buy = sc.nextInt();
                    user.shares += buy;
                    System.out.println("Bought successfully!");
                    break;

                case 3:
                    System.out.print("Enter shares to sell: ");
                    int sell = sc.nextInt();
                    if (sell <= user.shares) {
                        user.shares -= sell;
                        System.out.println("Sold successfully!");
                    } else {
                        System.out.println("Not enough shares!");
                    }
                    break;

                case 4:
                    System.out.println("Shares Owned: " + user.shares);
                    System.out.println("Portfolio Value: ₹" + (user.shares * stock.price));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}

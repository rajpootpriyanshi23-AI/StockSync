import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stock stock = new Stock("ABC", 100);
        int shares = 0;
        double balance = 10000;

        while (true) {
            System.out.println("\n1. Buy");
            System.out.println("2. Sell");
            System.out.println("3. Portfolio");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Shares to buy: ");
                    int buy = sc.nextInt();
                    balance -= buy * stock.price;
                    shares += buy;
                    break;

                case 2:
                    System.out.print("Shares to sell: ");
                    int sell = sc.nextInt();

                    if (sell <= shares) {
                        balance += sell * stock.price;
                        shares -= sell;
                    } else {
                        System.out.println("Not enough shares.");
                    }
                    break;

                case 3:
                    System.out.println("Balance: " + balance);
                    System.out.println("Shares: " + shares);
                    System.out.println("Portfolio Value: "
                            + (balance + shares * stock.price));
                    break;

                case 4:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
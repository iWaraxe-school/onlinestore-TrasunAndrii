package ua.issoft.store;

import java.util.Scanner;

public class ConsoleMenu {

    public static void getStart(Store store) {
        Scanner scanner = new Scanner(System.in);
        StoreHelper storeHelper = new StoreHelper();
        boolean whileFlag = true;
        while (whileFlag) {
            System.out.println("Available commands: \n1 - sort\n2 - top\n3 - quit\nPlease Input number of command:");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Top 5 products:");
                    storeHelper.printTop5(store);
                    break;
                case "2":
                    System.out.println("Start sorting...");
                    storeHelper.printSort(store);
                    break;
                case "3":
                    System.out.println("Goodbye...");
                    whileFlag = false;
                    break;
            }
        }
    }
}
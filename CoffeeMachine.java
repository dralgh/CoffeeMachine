package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void status(int[] a) {
        System.out.println("The coffee machine has:");
        System.out.println(a[0] + " of water");
        System.out.println(a[1] + " of milk");
        System.out.println(a[2] + " of coffee beans");
        System.out.println(a[3] + " of disposable cups");
        System.out.println(a[4] + " of money");
    } //Status action

    public static int[] sell(int[] a, int b[]) {
        a[0] -= b[0];
        a[1] -= b[1];
        a[2] -= b[2];
        a[3] -= b[3];
        a[4] += b[4];
        return a;
    } //Sell action

    public static String check(int[] a, int[] b) {
        String missing = null;
        if (a[0] - b[0] < 0) {
            missing = "Sorry, not enough water!";
        } else if (a[1] - b[1] < 0) {
            missing = "Sorry, not enough milk!";
        } else if (a[2] - b[2] < 0) {
            missing = "Sorry, not enough coffee beans!";
        } else if (a[3] - b[3] < 0) {
            missing = "Sorry, not enough disposable cups!";
        }
        return missing;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = {400, 540, 120, 9, 550}; //array with water, milk, beans, cups, money values.
        int[] espresso = {250, 0, 16, 1, 4}; //espresso costs
        int[] latte = {350, 75, 20, 1, 7}; //latte costs
        int[] cappuccino = {200, 100, 12, 1, 6}; //cappuccino costs
        boolean stop = false;
        do {
            System.out.println("Write an action (buy, fill, take, remaining, exit):");
            switch (scanner.next()) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    switch (scanner.next()) {
                        case ("1"):
                            if (check(a, espresso) == null) {
                                sell(a, espresso);
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                System.out.println(check(a, espresso));
                            }
                            break;
                        case ("2"):
                            if (check(a, latte) == null) {
                                sell(a, latte);
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                System.out.println(check(a, latte));
                            }
                            break;
                        case ("3"):
                            if ((check(a, cappuccino)) == null) {
                                sell(a, cappuccino);
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                System.out.println(check(a, cappuccino));
                            }
                            break;
                        case ("back"):
                            break;
                        default:
                            System.out.println("Order number not found.");
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add: ");
                    a[0] += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    a[1] += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    a[2] += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    a[3] += scanner.nextInt();
                    break;
                case "take":
                    System.out.println("I gave you " + a[4] + "$");
                    a[4] = 0;
                    break;
                case "remaining":
                    status(a);
                    break;
                case "exit":
                    stop = true;
                    break;
                default:
                    System.out.println("Unsupported action");
                    break;
            }
        } while (!stop);
    }
}

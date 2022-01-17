package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Converter {
    private static final String divider = "****************************";
    private static final ArrayList<String> currencies = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome! \n");
        getCurrencies().add("DKK");
        getCurrencies().add("EUR");
        getCurrencies().add("USD");
        home();
        System.out.println("****************************");
    }

    public static void home(){
        boolean status = false;
        while (!status) {

            System.out.println("Choose an option:");
            System.out.println("1. Currencies \n" + "2. Convert\n" + "9. Exit");

            Scanner option = new Scanner(System.in);
            int chosen = option.nextInt();

            if (chosen == 1){
                System.out.println(divider);

                for (String currency : currencies) {
                    System.out.println(currency);
                }
                System.out.println(divider);


            } else if (chosen == 2){
                System.out.println(divider);
                Scanner currencies = new Scanner(System.in);

                System.out.println("What do you wanna convert from?");
                String currencyFrom = currencies.nextLine();
                while (stringError(currencyFrom)){
                    System.out.println("What do you wanna convert from?");
                    currencyFrom = currencies.nextLine();
                }

                System.out.println("What do you wanna convert to?");
                String currencyTo = currencies.nextLine();
                while (stringError(currencyTo)) {
                    System.out.println("What do you wanna convert to?");
                    currencyTo = currencies.nextLine();
                }

                double currencyAmount;
                while (true){
                    System.out.println("Enter the amount of " + currencyFrom + " that should be converted to " + currencyTo);
                    try {
                        currencyAmount = Double.parseDouble(currencies.next());
                        convert(currencyFrom, currencyTo, currencyAmount);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input, try again.");
                    }
                }

            } else {
                System.out.println("Quitting...");
                status = true;
            }
        }
    }

    public static void convert(String from, String to, double amount) {
        final double EUR = 7.43;
        final double EUR_USD = 1.16;

        final double USD = 6.43;
        final double USD_EUR = 0.87;

        final double DKK_EUR = 0.13;
        final double DKK_USD = 0.16;

        switch (from) {
            case "DKK":
                if (to.equals("EUR")) {
                    double total = amount * DKK_EUR;
                    System.out.println(amount + " " + from + " is in total " + total + " " + to);
                    System.out.println(divider);
                } else if (to.equals("USD")) {
                    double total = amount * DKK_USD;
                    System.out.println(amount + " " + from + " is in total " + total + " " + to);
                    System.out.println(divider);
                }
                break;

            case "USD":
                if (to.equals("EUR")) {
                    double total = amount * USD_EUR;
                    System.out.println(amount + " " + from + " is in total " + total + " " + to);
                    System.out.println(divider);
                } else if (to.equals("DKK")) {
                    double total = amount * USD;
                    System.out.println(amount + " " + from + " is in total " + total + " " + to);
                    System.out.println(divider);
                }
                break;

            case "EUR":
                if (to.equals("USD")) {
                    double total = amount * EUR_USD;
                    System.out.println(amount + " " + from + " is in total " + total + " " + to);
                    System.out.println(divider);
                } else if (to.equals("DKK")) {
                    double total = amount * EUR;
                    System.out.println(amount + " " + from + " is in total " + total + " " + to);
                    System.out.println(divider);
                }
                break;
        }
    }

    public static boolean stringError(String check) {
        if (!currencies.contains(check)) {
            System.out.println("Invalid currency, try again.");
            return true;
        }
        return false;
    }

    public static ArrayList<String> getCurrencies() {
        return currencies;
    }
}

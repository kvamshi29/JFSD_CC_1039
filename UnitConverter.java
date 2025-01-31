import java.util.Scanner;

public class UnitConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n======= Unit Converter =======");
            System.out.println("1. Currency Conversion");
            System.out.println("2. Length Conversion");
            System.out.println("3. Weight Conversion");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> currencyConversion(scanner);
                case 2 -> lengthConversion(scanner);
                case 3 -> weightConversion(scanner);
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void currencyConversion(Scanner scanner) {
        double usdToInr = 86.661, eurToInr = 87.30, gbpToInr = 102.20, jpyToInr = 0.67;

        System.out.println("\n======= Currency Conversion =======");
        System.out.println("1. USD to INR\n2. EUR to INR\n3. GBP to INR\n4. JPY to INR");
        System.out.println("5. INR to USD\n6. INR to EUR\n7. INR to GBP\n8. INR to JPY");
        System.out.print("Choose an option: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
            return;
        }

        int choice = scanner.nextInt();
        System.out.print("Enter the amount: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();
        double convertedAmount = switch (choice) {
            case 1 -> amount * usdToInr;
            case 2 -> amount * eurToInr;
            case 3 -> amount * gbpToInr;
            case 4 -> amount * jpyToInr;
            case 5 -> amount / usdToInr;
            case 6 -> amount / eurToInr;
            case 7 -> amount / gbpToInr;
            case 8 -> amount / jpyToInr;
            default -> {
                System.out.println("Invalid option.");
                yield -1;
            }
        };

        if (convertedAmount != -1) {
            System.out.printf("Converted amount: %.2f\n", convertedAmount);
        }
    }

    private static void lengthConversion(Scanner scanner) {
        System.out.println("\n======= Length Conversion =======");
        System.out.println("1. Centimeters to Meters\n2. Meters to Centimeters");
        System.out.println("3. Inches to Centimeters\n4. Centimeters to Inches");
        System.out.println("5. Feet to Meters\n6. Meters to Feet");
        System.out.print("Choose an option: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next();
            return;
        }

        int choice = scanner.nextInt();
        System.out.print("Enter the value: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next();
            return;
        }

        double value = scanner.nextDouble();

        double convertedValue = switch (choice) {
            case 1 -> value / 100;
            case 2 -> value * 100;
            case 3 -> value * 2.54;
            case 4 -> value / 2.54;
            case 5 -> value * 0.3048;
            case 6 -> value / 0.3048;
            default -> {
                System.out.println("Invalid option.");
                yield -1;
            }
        };

        if (convertedValue != -1) {
            System.out.printf("Converted value: %.2f\n", convertedValue);
        }
    }

    private static void weightConversion(Scanner scanner) {
        System.out.println("\n======= Weight Conversion =======");
        System.out.println("1. Kilograms to Grams\n2. Grams to Kilograms");
        System.out.println("3. Pounds to Kilograms\n4. Kilograms to Pounds");
        System.out.println("5. Ounces to Grams\n6. Grams to Ounces");
        System.out.print("Choose an option: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next();
            return;
        }

        int choice = scanner.nextInt();
        System.out.print("Enter the value: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next();
            return;
        }

        double value = scanner.nextDouble();

        double convertedValue = switch (choice) {
            case 1 -> value * 1000;
            case 2 -> value / 1000;
            case 3 -> value * 0.453592;
            case 4 -> value / 0.453592;
            case 5 -> value * 28.3495;
            case 6 -> value / 28.3495;
            default -> {
                System.out.println("Invalid option.");
                yield -1;
            }
        };

        if (convertedValue != -1) {
            System.out.printf("Converted value: %.2f\n", convertedValue);
        }
    }
}

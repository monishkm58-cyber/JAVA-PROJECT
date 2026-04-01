import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static final Map<String, Double> rates = new HashMap<>();

    // Initialize exchange rates (base: USD)
    static {
        rates.put("USD", 1.0);
        rates.put("INR", 83.0);
        rates.put("EUR", 0.92);
        rates.put("GBP", 0.78);
        rates.put("JPY", 151.0);
    }

    public static double convert(String from, String to, double amount) {
        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            throw new IllegalArgumentException("Invalid currency code!");
        }

        double amountInUSD = amount / rates.get(from);
        return amountInUSD * rates.get(to);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Currency Converter =====");

        while (true) {
            try {
                System.out.println("\nAvailable currencies: " + rates.keySet());

                System.out.print("Enter FROM currency: ");
                String from = sc.next().toUpperCase();

                System.out.print("Enter TO currency: ");
                String to = sc.next().toUpperCase();

                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();

                double result = convert(from, to, amount);

                System.out.printf("Converted Amount: %.2f %s\n", result, to);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("\nDo you want to continue? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Thank you for using Currency Converter!");
                break;
            }
        }

        sc.close();
    }
}
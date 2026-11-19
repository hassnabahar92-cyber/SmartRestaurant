import java.util.Scanner;

public class SmartRestaurant {
    public static void main(String[] args) {
        // Constants
        try (Scanner scanner = new Scanner(System.in)) {
            // Constants
            final double DRINK_PRICE = 15.50;
            final double STUDENT_DISCOUNT = 0.10;
            final double SENIOR_DISCOUNT = 0.05;
            final double TIP_RATE = 0.10;
            
            // 1. Collect customer information
            System.out.print("Enter customer's name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter customer's age: ");
            int age = scanner.nextInt();
            
            System.out.print("Enter price of the meal: ");
            double mealPrice = scanner.nextDouble();
            
            System.out.print("Enter number of drinks ordered: ");
            int drinksOrdered = scanner.nextInt();
            
            System.out.print("Is the customer a student? (true or false): ");
            boolean isStudent = scanner.nextBoolean();
            
            System.out.print("Enter service rating (1 to 5): ");
            int rating = scanner.nextInt();
            
            // 2. Validate rating using comparison and logical operators
            if (rating < 1 || rating > 5) {
                System.out.println("Error: Invalid rating. Please enter a rating between 1 and 5.");
            } else {
                // 3. Calculate drinks cost and subtotal
                double drinksCost = drinksOrdered * DRINK_PRICE;
                double subtotal = mealPrice + drinksCost;
                
                // 4. Calculate discount (Student 10% is larger than Senior 5%, so check Student first)
                double discountAmount = 0.0;
                if (isStudent) {
                    discountAmount = subtotal * STUDENT_DISCOUNT;
                } else if (age >= 60) {
                    discountAmount = subtotal * SENIOR_DISCOUNT;
                } else {
                    discountAmount = 0.0;
                }
                
                // 5. Calculate tip (10% when rating is 4 or 5)
                double tipAmount = 0.0;
                if (rating == 4 || rating == 5) {
                    tipAmount = subtotal * TIP_RATE;
                } else {
                    tipAmount = 0.0;
                }
                
                // 6. Calculate final bill and cast to int
                double finalBill = subtotal - discountAmount + tipAmount;
                int wholeAmount = (int) finalBill;
                
                // 7. Print the required receipt
                System.out.println("\nSMART RESTAURANT");
                System.out.println("Customer: " + name);
                System.out.println("Meal: $" + mealPrice);
                System.out.println("Drinks: $" + drinksCost);
                System.out.println("Discount: $" + discountAmount);
                System.out.println("Tip: $" + tipAmount);
                System.out.println("Final bill: $" + finalBill);
                System.out.println("Whole amount: $" + wholeAmount);
            }
        }
    }
}

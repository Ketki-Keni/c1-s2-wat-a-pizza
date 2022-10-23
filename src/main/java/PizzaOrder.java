import java.util.Scanner;

public class PizzaOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Name : ");
        String customerName = scanner.next();
        System.out.print("Enter your Email : ");
        String customerEmail = scanner.next();
        System.out.print("Enter your Phone number : ");
        long phoneNum = scanner.nextLong();
        System.out.println("Enter your Address : ");
        String address = scanner.next();
        displayMenu();

        int pizzaSize = 0;
        int noOfPizza = 0;
        int noOfGarlicBread =0;
        int noOfBeverages = 0;
        float totalPizzaPrice = 0;
        float totalGarlicBreadPrice = 0;
        float totalBeveragePrice = 0;
        float totalBillAmount = 0;
        float totalPriceAfterDiscount = 0;
        int menuItemSlNum = 0;
        int contOrExit = 0;
        do {
            System.out.print("Enter 1 for Pizza, 2 for Garlic Bread and 3 for Beverages : ");
            menuItemSlNum = scanner.nextInt();

            switch (menuItemSlNum) {
                case (1):
                    System.out.print("Enter the size of pizza(1 - Regular, 2 - Medium, 3 - Large) : ");
                    pizzaSize = scanner.nextInt();
                    System.out.print("Please enter the number of pizza you want to order : ");
                    noOfPizza = scanner.nextInt();
                    float priceOfPizza = getPriceOfPizzaBasedOnSize(pizzaSize);
                    totalPizzaPrice = calculatePriceOfPizza(noOfPizza, priceOfPizza);
                    System.out.println("Your total Pizza Bill : $" + totalPizzaPrice);
                    break;
                case (2):
                    System.out.print("Please enter the number of Garlic Bread you want to order : ");
                    noOfGarlicBread = scanner.nextInt();
                    float priceOfGarlicBread = getPriceOfGarlicBread();
                    totalGarlicBreadPrice = calculatePriceOfGarlicBread(noOfGarlicBread, priceOfGarlicBread);
                    System.out.println("Your total Garlic Bread Bill : $" + totalGarlicBreadPrice);
                   break;
               case (3):
                    System.out.print("Please enter the number of Beverages you want to order : ");
                    noOfBeverages = scanner.nextInt();
                    float priceOfBeverages = getPriceOfBeverage();
                    totalBeveragePrice = calculatePriceOfBeverage(noOfBeverages, priceOfBeverages);
                    System.out.println("Your total Beverages Bill : $" + totalBeveragePrice);
                   break;
               default:
                    System.out.println("Invalid Sl No selected for menu");
                   break;
           }
            System.out.print("Do you want to place another order enter 1 to continue or 0 to exit : ");
            contOrExit = scanner.nextInt();
            if(contOrExit == 0)
            {
                displayCustomerDetails(customerName, customerEmail, phoneNum, address);
                displayOrderDetails(noOfPizza, noOfGarlicBread, noOfBeverages, pizzaSize, totalBillAmount, totalPriceAfterDiscount);
                totalBillAmount = calculateTotalBill(totalPizzaPrice, totalGarlicBreadPrice, totalBeveragePrice);
                totalPriceAfterDiscount = calculateDiscountAndReturnBillAmount(totalBillAmount);

            }
        } while (contOrExit == 1);
    }
    static void displayCustomerDetails(String customerName, String customerEmail, long phoneNo, String address) {
        System.out.println("----------------------");
        System.out.println("   Customer Details   ");
        System.out.println("----------------------");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Customer Phone Number : " + phoneNo);
        System.out.println("Customer email : " + customerEmail);
        System.out.println("Customer Address : " + address);
        System.out.println("-----------------------------------------------------------------");
    }

    static void displayMenu() {
        float regularPizzaPriceIn$ = 9.99f;
        float mediumPizzaPriceIn$ = 11.99f;
        float largePizzaPriceIn$ = 13.99f;
        float garlicBreadPriceIn$ = 5.99f;
        float beveragePriceIn$ = 1.99f;
        System.out.println("Sl No \t Item Category");
        System.out.println("------------------------");
        System.out.println("1) \t\t Pizza");
        System.out.println("   \t\t Price of One Regular Pizza : $" + regularPizzaPriceIn$);
        System.out.println("   \t\t Price of One Medium Pizza : $" + mediumPizzaPriceIn$);
        System.out.println("   \t\t Price of One Large Pizza : $" + largePizzaPriceIn$);
        System.out.println("2) \t\t Garlic Bread");
        System.out.println("   \t\t Price of One Garlic Bread : $" + garlicBreadPriceIn$);
        System.out.println("3) \t\t Beverages");
        System.out.println("   \t\t Price of One Beverage : $" + beveragePriceIn$);
    }

    public static float getPriceOfPizzaBasedOnSize(int pizzaSize) {
        float priceOfPizza = 0;
        if (pizzaSize == 1) {
            priceOfPizza = 9.99f;
        } else if (pizzaSize == 2) {
            priceOfPizza = 11.99f;
        } else if (pizzaSize == 3) {
            priceOfPizza = 13.99f;
        } else {
            System.out.println("Invalid size, Enter 1,2 or 3");
            priceOfPizza = 0;
        }
        return priceOfPizza;
    }

    public static float getPriceOfGarlicBread() {
        return 5.99f;
    }

    public static float getPriceOfBeverage() {
        return 1.99f;
    }

    public static float calculatePriceOfPizza(float noOfPizza, float priceOfPizza) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the number of pizza you want to order : ");
        int numOfPizzasOrdered = scanner.nextInt();
        float totalPriceOfPizzasOrdered = priceOfPizza * numOfPizzasOrdered;
        return totalPriceOfPizzasOrdered;
    }

    public static float calculatePriceOfGarlicBread(int noOfGarlicBread, float priceOfGarlicBread) {
        System.out.print("Please enter the number of Garlic Bread you want to order : ");
        Scanner scanner = new Scanner(System.in);
        int numOfGarlicBreadOrdered = scanner.nextInt();
        float totalPriceOfGarlicBreadOrdered = priceOfGarlicBread * numOfGarlicBreadOrdered;
        return totalPriceOfGarlicBreadOrdered;
    }

    public static float calculatePriceOfBeverage(int noOfBeverages, float priceOfBeverages) {
        System.out.print("Please enter the number of Beverages you want to order : ");
        Scanner scanner = new Scanner(System.in);
        int numOfBeveragesOrdered = scanner.nextInt();
        float totalPriceOfBeveragesOrdered = priceOfBeverages * numOfBeveragesOrdered;
        return totalPriceOfBeveragesOrdered;
    }

    public static float calculateTotalBill(float totalPizzaPrice, float totalGarlicBreadPrice, float totalBeveragePrice) {
        float totalBillAmount = totalPizzaPrice + totalGarlicBreadPrice + totalBeveragePrice;
        return totalBillAmount;
    }

    public static float calculateDiscountAndReturnBillAmount(float totalBillAmount) {
        if (totalBillAmount >= 50)
        {
            float discount = 10 / 100f;
            float discountAmount = totalBillAmount * discount;
            Float amountToPay = totalBillAmount - discountAmount;
            return amountToPay;
        }
        else
        {
            System.out.println("No discount provided since bill amount is less than $50");
            return totalBillAmount;
        }
    }

    //System.out.println("----------------------------Thank You---------------------------------");
    public static void displayOrderDetails(int noOfPizza, int noOfGarlicBread, int noOfBeverages, int size, float totalBillAmount, float totalPrizeAfterDiscount)
    {
        System.out.println("Order Details");
        System.out.println("--------------");
        System.out.println("The number of pizzas ordered :" + noOfPizza);
        System.out.println("The number of garlic bread ordered :" + noOfGarlicBread);
        System.out.println("The number of beverages ordered :" + noOfBeverages);
        System.out.println("-----------------------------------------------------------");
        System.out.println("The total Bill Amount is : $" + totalBillAmount);
        System.out.println("The Discounted Bill Amount : $" + totalPrizeAfterDiscount);
    }
}


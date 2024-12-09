package comprog;

import java.util.Scanner;

public class POS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int stockC1 = 20, stockC2 = 20, stockC3 = 20;
        int stockD1 = 20, stockD2 = 20, stockD3 = 20;
        float C1price = 99.0f, C2price = 130.50f, C3price = 159.0f;
        float D1price = 30.0f, D2price = 30.0f, D3price = 30.0f;


        char continueOrder = 'N';

        System.out.println("---------------Welcome to Jollibee!---------------");

        do {
            System.out.println("-------------------------------\nUpdated Stock Levels:");
            System.out.println("Main Meals:");
            System.out.println("C1 = " + stockC1 + " available");
            System.out.println("C2 = " + stockC2 + " available");
            System.out.println("C3 = " + stockC3 + " available");
            System.out.println("Main Drinks:");
            System.out.println("D1 = " + stockD1 + " available");
            System.out.println("D2 = " + stockD2 + " available");
            System.out.println("D3 = " + stockD3 + " available");
            System.out.println("-------------------------------");

            System.out.print("Do you want to buy a meal? (Y/N): ");
            char mainDishChoice = scan.next().charAt(0);

            String mainDish = "";
            int mainDishQuantity = 0;

            if (mainDishChoice == 'Y' || mainDishChoice == 'y') {
                System.out.println("-------------------------------\nFor main dish:");
                System.out.println("[P" + C1price + "] " + "C1 = 1pc Fried Chicken Ala Cart");
                System.out.println("[P" + C2price + "]" + "C2 = 1pc Fried Chicken with Rice and Fries");
                System.out.println("[P" + C3price + "]" + "C3 = 2pcs Fried Chicken with Spaghetti and Fries");

                System.out.print("What is your order? (C1, C2, C3): ");
                scan.nextLine();
                mainDish = scan.nextLine();
                System.out.print("How many " + mainDish + "? : ");
                mainDishQuantity = scan.nextInt();
                if ((mainDish.equals("C1") /*|| (mainDish.equals("c1")*/ && mainDishQuantity > stockC1 || stockC1 == 0) ||
                    (mainDish.equals("C2") && mainDishQuantity > stockC2 && stockC2 == 0) ||
                    (mainDish.equals("C3") && mainDishQuantity > stockC3 && stockC3 == 0)) {
                    System.out.println("\nSorry, not enough stock for " + mainDish + ". You may choose other meal");
                    continue;
                }
                
            }

            System.out.print("-------------------------------\nDo you want to order a drink? (Y/N): ");
            char drinkChoice = scan.next().charAt(0);

            String drink = "";
            int drinkQuantity = 0;

            if (drinkChoice == 'Y' || drinkChoice == 'y') {
                System.out.println("-------------------------------\nFor drinks:");
                System.out.println("[P" + D1price + "] " + "D1 = Coke");
                System.out.println("[P" + D2price + "] " + "D2 = Royal");
                System.out.println("[P" + D3price + "] " + "D3 = Sprite");

                System.out.print("What is your drink? (D1, D2, D3): ");
                scan.nextLine();
                drink = scan.nextLine();
                System.out.print("How many " + drink + "? ");
                drinkQuantity = scan.nextInt();

                if ((drink.equals("D1") && drinkQuantity > stockD1 && stockD1 == 0) ||
                    (drink.equals("D2") && drinkQuantity > stockD2 && stockD2 == 0) ||
                    (drink.equals("D3") && drinkQuantity > stockD3 && stockD3 == 0)) {
                    System.out.println("Sorry, not enough stock for " + drink + ". Please reduce the quantity.");
                    continue;
                }
            }

            if (mainDishChoice == 'Y' || mainDishChoice == 'y') {
                if (mainDish.equals("C1")) stockC1 -= mainDishQuantity;
                else if (mainDish.equals("C2")) stockC2 -= mainDishQuantity;
                else if (mainDish.equals("C3")) stockC3 -= mainDishQuantity;
            }

             if (drinkChoice == 'Y' || drinkChoice == 'y') {
                if (drink.equals("D1")) stockD1 -= drinkQuantity;
                else if (drink.equals("D2")) stockD2 -= drinkQuantity;
                else if (drink.equals("D3")) stockD3 -= drinkQuantity;
            }

            System.out.println("-------------------------------\nYour Orders:");
            if (mainDishChoice == 'Y' || mainDishChoice == 'y') {
                displayMainDishOrder(mainDish, mainDishQuantity);
//                dishsubtotal(mainDish, maindish_total,mainDishQuantity, C1price);
            }
            if (drinkChoice == 'Y' || drinkChoice == 'y') {
                displayDrinkOrder(drink, drinkQuantity);
//                drinksubtotal(drink, drink_total, drinkQuantity, D1price);
            }
            
            finaltotal(mainDish, mainDishQuantity, drink, drinkQuantity, C1price, C2price, C3price , D1price, D2price, D3price);

//            System.out.println("-------------------------------\nUpdated Stock Levels:");
//            System.out.println("C1 = " + stockC1 + " available");
//            System.out.println("C2 = " + stockC2 + " available");
//            System.out.println("C3 = " + stockC3 + " available");
//            System.out.println("D1 = " + stockD1 + " available");
//            System.out.println("D2 = " + stockD2 + " available");
//            System.out.println("D3 = " + stockD3 + " available");

            System.out.print("\nDo you want to place another order? (Y/N): ");
            continueOrder = scan.next().charAt(0);

            } 
            while (continueOrder == 'Y' || continueOrder == 'y');

        System.out.println("Thank you for visiting Jollibee! Come again!");
        scan.close();
    }

    public static void displayMainDishOrder(String mainDish, int quantity) {
        if (mainDish.equals("C1")){
                System.out.println(quantity + " x C1 - 1pc Fried Chicken Ala Cart");
                System.out.println("- " + quantity + " pc Fried Chicken");
        }
    else if (mainDish.equals("C2")){
                System.out.println(quantity + " x C2 - 1pc Fried Chicken with Rice and Fries");
                System.out.println("- " + quantity + " pc Fried Chicken");
                System.out.println("- " + quantity + " pc Rice");
                System.out.println("- " + quantity + " pc Fries");
    }
    else if (mainDish.equals("C3")){
                System.out.println(quantity + " x C3 - 2pcs Fried Chicken with Spaghetti and Drinks");
                System.out.println("- " + (2 * quantity) + " pcs Fried Chicken");
                System.out.println("- " + quantity + " pc Spaghetti");
                System.out.println("- " + quantity + " pc Drink (included)");
        }
    }

    public static void displayDrinkOrder(String drink, int quantity) {
        if (drink.equals("D1")){
            System.out.println(quantity + " x Coke");
        }
        else if (drink.equals("D2")){
            System.out.println(quantity + " x Royal");
        }
        if (drink.equals("D3")){
            System.out.println(quantity + " x Sprite");
        }
    }
    
//    public static void dishsubtotal(String mainDish, double maindish_total, int mainDishQuantity, float C1price){
//        if (mainDish.equals("C1")){
//        maindish_total = (mainDishQuantity * C1price);
//        
//        System.out.println("Subtotal : P" + maindish_total);
//    }
//    }
//    
//    public static void drinksubtotal(String drink, double drink_total, int drinkQuantity, float D1price){
//        if (drink.equals("D1")){
//        drink_total = (drinkQuantity * D1price);
//        
//        System.out.println("Subtotal : P" + drink_total);
//    }
//    }
//    
    public static void finaltotal(String mainDish, int mainDishQuantity, String drink, int drinkQuantity,float C1price, float C2price, float C3price ,float D1price, float D2price, float D3price){      
        float dishtotal = 0, drinktotal = 0;
        
        if (mainDish.equals("C1")){
            dishtotal = (C1price * mainDishQuantity);
        }
        else if (mainDish.equals("C2")){
            dishtotal = (C2price * mainDishQuantity);
        }
        if (mainDish.equals("C3")){
            dishtotal = (C3price * mainDishQuantity);
        }
        
        
        if (drink.equals("D1")){
            drinktotal = (D1price * drinkQuantity);
        }
        else if (drink.equals("D2")){
            drinktotal = (D2price * drinkQuantity);
        }
        else if (drink.equals("D3")){
            drinktotal = (D3price * drinkQuantity);
        }
        
        System.out.println("Total : " + (dishtotal + drinktotal));
    }
}
package old;

import java.util.Scanner;
//import java.io.Console;
public class Startpage {
//    var  con = System.console();
//     if (con != null) {
//         Scanner sc = new Scanner(con.reader());
//         int i = sc.nextInt();
//     }

static String MainMenuOptions = """
        ===== STORE MENU =====
                1. View all products
                2. View products by category
                3. Add product to cart
                4. View cart
                5. Remove product from cart
                6. Apply discount (if available)
                7. Checkout
                8. Exit
                =======================
                Enter your choice: 

        """;


//  public static void main(String[] args) {
public static void StartMenu(){
        System.out.print(MainMenuOptions);

        

        // int choice; 
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

         sc.close();

         switch (choice) {
                case 1:

                        
                        break;
         
                default:
                        break;
         }
   
   
    
    

        }
}



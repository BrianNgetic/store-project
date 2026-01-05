package old;

import java.util.Scanner;

public class AdminStartpage{


    static String welcome = """
            ===== ADMIN PANEL =====
                1. View all products
                2. Add new product
                3. Update product quantity
                4. Remove product
                5. View sales report
                6. Return to main menu
                ========================
                Enter your choice:

            """;


public static void AdminStartMenu() {
        System.out.print(welcome);
        

        // int choice; 
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

         sc.close();

         switch (choice) {
                case 1:
                        
                        
                        break;
                case 2:


                        break;
                case 3:

                        break;

                case 4:
                        
                        break;
                
                case 5:
                

                        break;
                case 6:

                        Startpage.StartMenu();

                        break;
         
                default:
                        break;
         }
   
   
    }
    



}
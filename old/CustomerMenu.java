package old;

import java.util.Scanner;

public class CustomerMenu {


                //import java.io.Console;

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
                public static void showMenu() {
                        System.out.print(MainMenuOptions);
                
                        Scanner sc = new Scanner(System.in);
                       int input =  sc.nextInt();


                       switch(input){
                        case 1 ->{
                                viewProducts.displayAllProducts();
                        }

                        case 2 ->{
                                viewProducts.displayByCategory();
                        }
                       }



                        sc.close();
                
                
                }
                


}

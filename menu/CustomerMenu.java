package menu;

public class CustomerMenu {

   
    static String mainmenu = """
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
        public static  void showMenu(){
                System.out.println(mainmenu);
        }
    
}

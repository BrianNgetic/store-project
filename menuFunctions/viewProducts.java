
package menuFunctions;

import java.io.*;
import java.util.*;
import products.Food;



public class viewProducts {
   
   
    public static void displayAllProducts() {
    try{
            BufferedReader Clothreader = new BufferedReader(new FileReader("data/Clothing.txt"));
            BufferedReader Electronicsreader = new BufferedReader(new FileReader("data/Electronics.txt"));
            BufferedReader Foodreader = new BufferedReader(new FileReader("data.clothing.txt"));

            String Clothline, Electronicline, Foodline;
        
                // while (((Clothline = Clothreader.readLine()) != null) &&
                //     ((Electronicline = Electronicsreader.readLine()) != null) &&
                //     ((Foodline = Foodreader.readLine()) != null)) {
                //     // Your code to process the lines goes here
                //    System.out.println(Clothline + ", " + Electronicline + ", " + Foodline);
                // }

                    
                    System.out.println("===========Clothes=================");
                    
                    while (((Clothline = Clothreader.readLine()) != null)){
                        System.out.println(Clothline); //prints all the clothes
                    } 

                     System.out.println("===========Electronics================");
                   while((Electronicline = Electronicsreader.readLine()) != null){
                            System.out.println(Electronicline);
                    }


                    System.out.println("===========Foood================");
                    while((Foodline = Foodreader.readLine()) != null){
                        System.out.println(Foodline);
                    }

 
                   

                    


        }catch(Exception e){
            e.printStackTrace();
        }
    }





    public static void displayByCategory(){
        
        String categories = """

               ========Categories============
               1.Clothes
               2.Electronics
               3.Food
        """;

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch(input){
            case 1 ->{
                try {

                     BufferedReader Clothreader = new BufferedReader(new FileReader("data/Clothing.txt"));
                     String Clothline;

                     System.out.println("===========Clothes=================");
                    
                            while (((Clothline = Clothreader.readLine()) != null)){
                                System.out.println(Clothline); //prints all the clothes
                            } 



                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 2 ->{
                try {
                     BufferedReader Electronicsreader = new BufferedReader(new FileReader("data/Electronics.txt"));
                     String  Electronicline;

                       System.out.println("===========Electronics================");
                   while((Electronicline = Electronicsreader.readLine()) != null){
                            System.out.println(Electronicline);
                    }



                } catch (Exception e) {
                     e.printStackTrace();
                }
            }


            case 3->{
                try {

                     BufferedReader Foodreader = new BufferedReader(new FileReader("data.clothing.txt"));
                     

                     String Foodline;

                      System.out.println("===========Foood================");
                    while((Foodline = Foodreader.readLine()) != null){
                        System.out.println(Foodline);
                    }

                    
                } catch (Exception e) {
                          e.printStackTrace();

                }
            }


            default ->System.out.println("Enter a valid option: "); 


        
        }


    }
}

package products;

import java.io.*;
import java.lang.*;
// import users.string;


public class Food  extends Product{
    
    //variables
    char[] expirationDate;
    class Nutrition{
        int protein;
        int carbs;
        int fat;
        double calories ;
    }

                //functions
    //mutators
   // nutrutition accessor and modifier fuction to be added soon


   
       public void  ReadfromElectronicFile(){
        
   
        try
        {
           BufferedReader ReadfromElectronicsFile  = new BufferedReader(new FileReader("data/Electronics.txt"));
            String line;
            if((line  = ReadfromElectronicsFile.readLine()) != null){
                String[] parts = line.split(",");

                name = parts[0];
                price = Double.parseDouble(parts[1]);
                stock = Integer.parseInt(parts[2]);
                discount = Double.parseDouble(parts[3]);
                expirationDate =  parts[4].toCharArray(); ///02022005 becomes [0,2,0,2,2,0,0,5]
                Nutrition foodItem = new Nutrition(); //instantiate the class and assin memory of size nutrition hence the new
                foodItem.protein = Integer.parseInt(parts[5]);
                foodItem.carbs = Integer.parseInt(parts[6]);
                foodItem.fat = Integer.parseInt(parts[7]);
                foodItem.calories =  ((foodItem.protein * 4) + (foodItem.carbs * 4) + (foodItem.fat * 9));
                 
                


            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       }
    


    //accessors
    boolean  isExpired(){

        return true; ///to be changed
    }
    
    String getexpirationDate(){


        StringBuilder  expiry =  new StringBuilder();

        for(int i = 0; i < expirationDate.length; i++){
            expiry.append(expirationDate[i]);
            if(i == 1 || i== 3){ // [0,2,0,2,2,0,0,5] becomes [0,2,/,0,2,/,2,0,0,5]
                expiry.append("/");
            }
            


            
        }
        return expiry.toString();
   

    }

    Nutrition getnutritionInfo(){ // to be changed

        return null ;
    }


    // @Override
    // void applydiscount() {
    //     // TODO
      
    // }

    // @Override
    // void updatestock() {
    //     // TODO

    // }

    // @Override
    // double calcTotal() {
    //     // TODO
    //     return total;
    // }

    @Override
    String getname() {
        // TODO
        return name; 
    }

    @Override
    double getprice() {
        // TODO
        return price;
    }

    @Override
    int getstock() {
        // TODO
        return stock;
    }
}

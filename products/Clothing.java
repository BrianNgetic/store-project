
package products;
import java.io.*;
import java.lang.*;

public class Clothing  extends  Product{

    String size;
    String color;
  

       public void  ReadfromClothFile(){
        
   
        try
        {
           BufferedReader ReadfromClothFile  = ReadfromClothFile= new BufferedReader(new FileReader("data/Clothing.txt"));
            String line;
            if((line  = ReadfromClothFile.readLine()) != null){
                String[] parts = line.split(",");

                name = parts[0];
                price = Double.parseDouble(parts[1]);
                stock = Integer.parseInt(parts[2]);
                discount = Double.parseDouble(parts[3]);
                size = parts[4];
                color = parts[5];




            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       }
    

    // String getSizeOptions(){
    //     return size; // to be changed...this is just to remove that annoying red line
    //                 //if the number of a size > 1, return the size, if it is less than 10, 
    //                 //return the stock remaining ass well
                    //to be implimented when I redesign the structure of the txt. or now just one
                    //size for each item
    // }
    // void ChooseDiffColor(String newColor){ //this function will check if the stock in a particular color is 
    //                         //available, if so it will add that , reduce the stock in that price
    //                         //and add stock to the prev color

    //                 color = newColor;
                    //also to be implimented later when I decide how I wnat my clothes.txt to loook like
    // // }
    // boolean  returnEligibility(){
    //     return true; //also to be changed
    //                 //function to ask for the date bought, if is more than 30 days, return false, 
    //                 //else return true;
    // }
 

    

    // @Override
    // void applydiscount() {
    //     // TODO
    // }

    // @Override
    // void updatestock() {
    //     // TODO
    // }

  //  @Override
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

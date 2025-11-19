
package products;

import java.io.*;
// import java.lang.*;

public class Electronics extends  Product{

    
    boolean  warrantyElible;
    int warrantyPeriod;
    int batteryLevel;
    double productVersion;
    
    private static int updatedProductVersion;



    
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
                warrantyElible =Boolean.parseBoolean(parts[4]);
                warrantyPeriod = Integer.parseInt(parts[5]);
                batteryLevel = Integer.parseInt(parts[6]);
                productVersion = Double.parseDouble(parts[7]);



                     p            }
            ReadfromElectronicsFile.close(); //prevent resource leak
        }
        catch(Exception e){
            e.printStackTrace();
        }
       }
    

    int getwarrantyPeriod(){
        return warrantyPeriod;
    }
    int checkbatteryLevel(){
        return batteryLevel;
    }
    void updateversion(){
        //update the product version
        productVersion = updatedProductVersion;
    }
    boolean isunderWarranty(){
        return warrantyElible;// only true if it was less than 30 days ago. 
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
    //     return total;
    //     // TODO
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


package products;

public class Food  extends Product{
    
    //variables
    int expirationDate;
    class nutrition{
        int protein;
        int carbs;
        int fat;
        double calories = (protein * 4) + (carbs * 4) + (fat * 9);
    }

                //functions
    //mutators
   // nutrutition accessor and modifier fuction to be added soon

    //accessors
    boolean  isExpired(){

        return true; ///to be changed
    }
    
    int getexpirationDate(){
        return expirationDate;
    }

    nutrition getnutritionInfo(){ // to be changed

        return null ;
    }


    @Override
    void applydiscount() {
        // TODO
      
    }

    @Override
    void updatestock() {
        // TODO

    }

    @Override
    double calcTotal() {
        // TODO
        return total;
    }

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

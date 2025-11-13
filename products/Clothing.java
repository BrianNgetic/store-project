package products;

public class Clothing  extends  Product{

    String size;
    String color;
  


    String getSizeOptions(){
        return size; // to be changed...this is just to remove that annoying red line
                    //if the number of a size > 1, return the size, if it is less than 10, 
                    //return the stock remaining ass well
    }
    void ChooseDiffColor(){ //this function will check if the stock in a particular color is 
                            //available, if so it will add that , reduce the stock in that price
                            //and add stock to the prev color
    }
    boolean  returnEligibility(){
        return true; //also to be changed
                    //function to ask for the date bought, if is more than 30 days, return false, 
                    //else return true;
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

package products;

public class Electronics extends  Product{

    
    boolean  warrantyElible;
    int warrantyPeriod;
    int batteryLevel;
    double productVersion;

    int getwarrantyPeriod(){
        return warrantyPeriod;
    }
    int checkbatteryLevel(){
        return batteryLevel;
    }
    void updateversion(){
        //update the product version
    }
    boolean isunderWarranty(){
        return true ;// only true if it was less than 30 days ago. 
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
        return total;
        // TODO
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

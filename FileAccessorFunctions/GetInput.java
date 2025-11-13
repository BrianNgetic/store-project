package FileAccessorFunctions;
import users.Customer;
import java.io.*;
public class GetInput {

    public static BufferedReader createReader(){
   
       return new  BufferedReader(new BufferedReader(new InputStreamReader(System.in)));

        
    }
  
    

    // public static BufferedReader ReadFromFile(File inputFile){
    //     return new BufferedReader(new BufferedReader(File inputFile));
    // }
}

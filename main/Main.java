package main;

import java.io.*;
import java.util.*;
// import java.lang.*;

import FileAccessorFunctions.GetInput;
import Exceptions.FileExceptions;

//note to self

import users.Customer;
import menu.CustomerMenu;
public class Main {

    public static void main(String[] arguments) {
      

        
            // System.out.println("WELCOME TO MY STORE");
            // System.out.println("Are you an Admin or a Customer");
            // System.out.println("Press 1 if ");

            String MultilineWelcome = """
                   
                    WELCOME TO MY STORE
                    Are you an Admin(1) or a Customer(2)                 

                    """;

            System.out.println(MultilineWelcome);
            try (BufferedReader reader = GetInput.createReader()) {
                String  typeuser = reader.readLine();
                
                if(null == typeuser){
                    System.out.println("Enter a valid option. ");
                
                }
                
                
               
                switch (typeuser) {
                        case "1" -> {   

                            //get email

                            outerblock: {
                            System.out.println("Enter your Email");
                            
                            Customer user = new Customer(); //create new instance of customer
                            user.Email = (reader.readLine()); //assin the email to the input of user
                            //we need to check if the email already exists
                            //if it does, we ask for the password and check if they are same
                            //if it doesnt we ask for a passsword that will now be linked to this email.

                            //read file
                            BufferedReader ReadFromFile = null;
                            try{
                                 ReadFromFile = new BufferedReader(new FileReader("data/userData.txt"));
                                // String  line = ReadFromFile.readLine();
                                //outerloop:
                                String line ;
                                //if file is empty
                                
                                boolean founduser = false;
                                String Email;
                                String password;
                                    //iiterate till the file is over.
                                
                                 while ((line  = ReadFromFile.readLine()) != null)
                                {
                                        
                                       
                                        if (line.trim().isEmpty()) continue;
                                        

                                        
                                        String[] parts = line.split(","); // each line now loos lile
                                        
                                         Email = parts[0]; //get the email
                                         password =(parts[1]); //get the password as  a string
                                                                    //int wont work because we want the password to have special
                                                                    //characters as well

                                        
                                        if(Email.equals(user.Email)) {
                                        founduser = true;
                                        user.Password = password;
                                        break;
                                        }
                                        

                                        // System.out.print(founduser);
                                }
                                if(founduser == true) {//the user exists
                                        //ask for password;
                                        System.out.println("WElcome back Valued Customer");
                                        System.out.println("Enter your password");
            
                                        String returningUserPassword= reader.readLine();

                                        if(returningUserPassword.equals(user.Password)){ //password is same
                                            System.out.println("Here are our updated store menu options: ");
                                            CustomerMenu.showMenu();
                                        }
            
                                        else{
                                            int count  = 3;
                                                 do { //dont match, 
                                                
                                                        System.out.println("Sorry, That Password is incorrect, try again");
                                                
                                                        System.out.println(" you have " + (count)+ "attempts left");
                                                        count--;
                                                        returningUserPassword = reader.readLine();
                                                        if(count <= 0) {
                                                            System.out.println("You have exceeded the number of tries");
                                                            break  outerblock;
                                                        } 
                                                      
                                                        
                                                        //going to pause this for now..to come back to later;
                                                        // if(count >4 ){
                                                        //     System.out.println(MultilineWelcome);
                                                        //     break outerloop; // go back to men
                                                        // }
                                                        
                                                 }while(returningUserPassword.equals(user.Password));
                                           }
                                              
                                           
                                            
                                            // scanner.close();
                                    } else if(founduser == false){
                                        System.out.println("Weclcome to our site");
                                        System.out.println("Create  a password");
                                        
                                        String newUserPassword = reader.readLine();

                                         try( BufferedWriter newUser = new BufferedWriter(new FileWriter("data/userData.txt", true))){
                                                    newUser.write(user.Email +"," + newUserPassword ); //add email and password to list
                                                    //email, password
                                                    newUser.newLine();
                                                    System.out.println("Your information has been successfully saved"); //save info
                                                    CustomerMenu.showMenu(); //show screen
                                                }
                                        catch(Exception e){
                                                    e.printStackTrace();
                                                }
                                        
                                       
                                    }
                                       
                                        
                            }catch(Exception e){
                                e.getMessage();
                            }
                            finally{
                                
                                ReadFromFile.close(); //close file. 
                            }
                           
                            // user.Password = Integer.parseInt(UserInfo.readLine());
                        }
                        }

                        case "2" -> { //NOtE::Come back and do the admin side.
                        }

                        default -> System.out.println("Enter a valid option. ");
                    }
            }
            catch(Exception e){
                e.printStackTrace();
            }

       
    
    }
}

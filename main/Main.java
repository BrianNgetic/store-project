package main;

import java.io.*;
// import java.lang.*;

import FileAccessorFunctions.GetInput;

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
                            BufferedReader UserInfo = GetInput.createReader();
                            Customer user = new Customer(); //create new instance of customer
                            user.Email = (UserInfo.readLine()); //assin the email to the input of user
                            //we need to check if the email already exists
                            //if it does, we ask for the password and check if they are same
                            //if it doesnt we ask for a passsword that will now be linked to this email.

                            //read file
                            BufferedReader ReadFromFile = null;
                            try{
                                 ReadFromFile = new BufferedReader(new FileReader("data/userData.txt"));
                                // String  line = ReadFromFile.readLine();
                                //outerloop:
                                String line = ReadFromFile.readLine();
                                System.out.println("DEBUGGING: " + line);

                                //if file is empty
                                if(("data/userData.txt").length() == 0){
                                    
                                    //if the file is empty, hence no previous customers
                                    //we need to add the email and ask  for a password to also add
                                    //since we already have the emial, ask him  a good password then add both of them together
                                    
                                    
                                    //prompt the user for password and store it inthe user.password
                                    //this is the first customer
                                    System.out.println("DEBUGGING:: NEW USER FILE EMPTY");
                                    System.out.println("Welcome  " + user.Email  );
                                    System.out.println("Create a Password");
                                    
                                    user.Password =((UserInfo.readLine()));// get the  to input and add password
                                    try( BufferedWriter FirstUser = new BufferedWriter(new FileWriter("data/userData.txt", true))){
                                        FirstUser.write(user.Email +"," + user.Password); //add email and password to list
                                        //email, password
                                        FirstUser.newLine();
                                    }
                                    catch(Exception e){
                                        e.getMessage();
                                    }
                            
                                    System.out.println("Your information was Successfully saved");
                                    CustomerMenu.showMenu(); //show the cuustomer meny
                                    
                                } 
                                else //file isnt  empty
                                {
                            
                            
                                    
                                    //iiterate till the file is over.
                                    while ((line  = ReadFromFile.readLine()) != null){
                                        
                                          System.out.println("DEBUGGING: " + line);
                                        
                                        String[] parts = line.split(","); // each line now loos lile
                                        
                                        String Email = parts[0]; //get the email
                                        String password =(parts[1]); //get the password as  a string
                                                                    //int wont work because we want the password to have special
                                                                    //characters as well

                                        
                                        if(Email.equals(user.Email)) {
                                            //check if the email is in the file
                                            //if it is, check if the password matches
                                            
                                            //for debugging
                                            System.out.println("Welcome returning user");
                                            System.out.println("Enter Your Password");
                                        
                                            user.Password =((UserInfo.readLine())); //get the input frm the user to compare
                                            
                                            int count = 0; //keeps track of the numeber of sign in attempts
                                           
                                
                                             if(user.Password.equals(password)){
                                                //if it does match. Show them the main menu.
                                                System.out.println("Your information was Successfully saved");
                                                CustomerMenu.showMenu(); //show the cuustomer meny
                                            
                                            }
                                            else{
                                                 do { //dont match, 
                                                
                                                        System.out.println("Sorry, That Password is incorrect, try again");
                                                        count++;
                                                        System.out.println(" you have " + (4-count)+ "attempts left");
                                                        if(4-count <= 0) break  outerblock;
                                                        user.Password = (UserInfo.readLine()); //get input again
                                                        
                                                        //going to pause this for now..to come back to later;
                                                        // if(count >4 ){
                                                        //     System.out.println(MultilineWelcome);
                                                        //     break outerloop; // go back to men
                                                        // }
                                                        
                                                 }while(!(user.Password.equals(password)));
                                           }
                                              
                                            
                                            
                                        }
                                        else //file isnt empty but the email isnt on the file, new user
                                        {
                                                
                                                System.out.println("Welcome to our site");
                                                System.out.println("Create a password");
                                                user.Password = UserInfo.readLine();


                                                //if the file isnt empty but the email isnt in the database(new user)
                                                    //append the email and password
                                                try( BufferedWriter newUser = new BufferedWriter(new FileWriter("data/userData.txt", true))){
                                                    newUser.write(user.Email +"," + user.Password); //add email and password to list
                                                    //email, password
                                                    newUser.newLine();
                                                    System.out.println("Your information has been successfully saved"); //save info
                                                    CustomerMenu.showMenu(); //show screen
                                                }
                                                catch(Exception e){
                                                    e.getMessage();
                                                }
                                        }

                                        
                                    }
                                }
                                
                               
                                
                               
                            }
                            catch(Exception e){
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

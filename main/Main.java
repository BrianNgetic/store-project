package main;

import java.io.*;
// import java.lang.*;

import FileAccessorFunctions.GetInput;

//note to self

import users.Customer;
import menu.CustomerMenu;
public class Main {

    public static void main(String[] arguments) {
        try{

        
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
                
                
                else //this is where I want the user to come back to ;

                    switch (typeuser) {
                        case "1" -> {
                            System.out.println("Enter your Email");
                            BufferedReader UserInfo = GetInput.createReader();
                            Customer user = new Customer(); //create new instance of customer
                            user.Email = (UserInfo.readLine()); //assin the email to the input of user
                            //we need to check if the email already exists
                            //if it does, we ask for the password and check if they are same
                            //if it doesnt we ask for a passsword that will now be linked to this email.
                            try {
                                BufferedReader ReadFromFile = new BufferedReader(new FileReader("data/userData.txt"));
                                String line;
                                //outerloop:
                                if((line = ReadFromFile.readLine()) == null){
                                    
                                    //if the file is empty, hence no previous customers
                                    //we need to add the email and ask him for a password to also add
                                    //since we already have the emial, ask him  a good password then add both of them together
                                    
                                    
                                    //prompt the user for password and store it inthe user.password
                                    System.out.println("Enter a Password");
                                    
                                    user.Password =((UserInfo.readLine()));// get the  to input and add password
                                    try( BufferedWriter FirstUser = new BufferedWriter(new FileWriter("data/userData.txt", true))){
                                        FirstUser.write(user.Email +"," + user.Password); //add email and password to list
                                        //email, password
                                    }
                                    catch(Exception e){
                                        e.printStackTrace();
                                    }
                                    
                                System.out.println("Your information was Successfully saved");
                                    CustomerMenu.showMenu(); //show the cuustomer meny
                                    
                                }
                                //if the file is not empty
                                else while ((line = ReadFromFile.readLine()) != null){
                                    
                                    String[] parts = line.split(","); // each line now loos lile
                                    
                                    String Email = parts[0]; //get the email
                                    String  password =(parts[1]); //get the password as  a string
                                                                //int wont work because we want the password to have special
                                                                //characters as well
                                    System.out.println("Enter Your Password");
                                    
                                    user.Password =((UserInfo.readLine())); //get the input frm the user to compare
                                    
                                    if(Email.equals(user.Email)) {//check if the email is in the file
                                        //if it is, check if the password matches
                                        
                                        int count = 0; //keeps track of the numeber of sign in attempts
                                        while(user.Password != password){ //dont match
                                            
                                            System.out.println("Sorry, That Password is incorrect, try again");
                                            count++;
                                            System.out.println(" you have " + (4-count)+ "attempts left");
                                            user.Password = (UserInfo.readLine()); //get input again
                                            
                                            //going to pause this for now..to come back to later;
                                            // if(count >4 ){
                                            //     System.out.println(MultilineWelcome);
                                            //     break outerloop; // go back to men
                                            // }
                                            
                                        }
                                        //if it does match. Show them the main menu.
                                          System.out.println("Your information was Successfully saved");
                                          CustomerMenu.showMenu(); //show the cuustomer meny
                                
                                        
                                        
                                    }
                                    else{ //if the file isnt empty but the email isnt in the database(new user)
                                        //append the email and password
                                         try( BufferedWriter newUser = new BufferedWriter(new FileWriter("data/userData.txt", true))){
                                        newUser.write(user.Email +"," + user.Password); //add email and password to list
                                        //email, password
                                        System.out.println("Your information has been successfully saved");
                                    }
                                    catch(Exception e){
                                        e.printStackTrace();
                                    }


                                    }
                                    
                                    
                                }
                                

                              
                                
                                ReadFromFile.close();
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                            // user.Password = Integer.parseInt(UserInfo.readLine());
                        }
                        case "2" -> { //NOtE::Come back and do the admin side.
                        }
                        default -> System.out.println("Enter a valid option. ");
                    }
            }catch(Exception e){
                e.printStackTrace();
            }


    }
    catch(Exception e){
        e.printStackTrace();
    }
    
}
}





    

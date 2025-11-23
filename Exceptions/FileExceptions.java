package Exceptions;

public class FileExceptions{

    public static class InvalidUserRecordException extends Exception {
        public InvalidUserRecordException(){
            super("Corrcupted line / Line not formatted correctly");
        }
        public InvalidUserRecordException(String message){
            super(message);
        }
    }
    public static class UserNotFoundException extends Exception {
        //not going to use this yet as I have not introduced the logic of wheather they are new or returning. 
    }
    public static class DuplicateEmailException extends Exception {
        public DuplicateEmailException(){
            super("Sorry, This Email is already Taken.");

        }

        public DuplicateEmailException(String message){
            super(message);
        }
    }
    public static class WrongPasswordException extends Exception {
        public WrongPasswordException(){
            super("Wrong Password. Try again");
        }
        public WrongPasswordException(String message){
            super(message);
        }
    }
    public static class TooManyAttemptsException extends Exception {
        public TooManyAttemptsException(){
            super("You have exceded the Maximum number of attempts");
        }
        public  TooManyAttemptsException(String message){
            super(message);
        }
    }
    public static class WeakPasswordException extends Exception {}
  


}

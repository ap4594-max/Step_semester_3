package StringOperations;

public class ATM {
    static void checkPinLength(String pin){
        if(pin.length() != 4){
            System.out.println("Invalid PIN");
        }
        else{
            System.out.println("PIN length OK");
        }
    }
    public static void main(String[] args) {
        checkPinLength("12345");
        checkPinLength("1234");
        
    }
}

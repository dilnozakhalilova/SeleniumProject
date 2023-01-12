package Class16_DevelopFunctions;

public class CustomExceptionExample {
    public static void main(String[] args) {
        int myInt = 10;
        if(myInt>5){
            System.out.println("Hi");
            }else {
            try{
            System.out.println("Custom error method come here");
            throw new Exception(String.valueOf(myInt));
        }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

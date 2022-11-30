package Class7;

public class BlankEmpty {
    public static void main(String[] args) {

        String blank=" ";
        String empty=" ";// in Java space is considered to be a character, and it is not EMPTY
        System.out.println("str1 = " + blank.isBlank());
        System.out.println("str2 = " + empty.isEmpty());
    }
}

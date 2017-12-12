package recursion;

public class BinaryRecursion {
    public static void main(String[] args) {
        printInbinary(100);
    }

    public static void printInbinary(int n){
        if(n < 2){
            System.out.print(n);
        }else{
            printInbinary(n / 2);
            System.out.print(n % 2);
        }
    }
}

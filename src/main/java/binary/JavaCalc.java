package binary;

public class JavaCalc {
    public static void main(String[] args) {


//        System.out.println(Integer.toBinaryString(5));
//        System.out.println(5 << 5);
//        System.out.println(Integer.toBinaryString(5 << 5));
//        System.out.println(Integer.toBinaryString(5 >> 3));

        String num6 = "00000111";
        String num1 = "00001011";
        int a = Integer.parseInt(num6, 2);
        int b = Integer.parseInt(num1, 2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
        System.out.println(Integer.toBinaryString(~a));
        System.out.println(~a);
    }
}

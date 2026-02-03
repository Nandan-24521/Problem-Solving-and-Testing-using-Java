package Prime;

import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

public class Main {

    public static PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return (int a) -> {
            if (a <= 1) return false;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return (int a) -> {
            int original = a;
            int rev = 0;
            while (a > 0) {
                rev = rev * 10 + a % 10;
                a /= 10;
            }
            return original == rev;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int type = sc.nextInt();
            int num = sc.nextInt();

            PerformOperation op;
            boolean result;

            if (type == 1) {
                op = isOdd();
                result = op.check(num);
                System.out.println(result ? "ODD" : "EVEN");
            } 
            else if (type == 2) {
                op = isPrime();
                result = op.check(num);
                System.out.println(result ? "PRIME" : "COMPOSITE");
            } 
            else if (type == 3) {
                op = isPalindrome();
                result = op.check(num);
                System.out.println(result ? "PALINDROME" : "NOT PALINDROME");
            }
        }
        sc.close();
    }
}

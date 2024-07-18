import java.math.BigInteger;

public class Set1 {
    public static void main(String[] args) {
        int[] numbers = {10, 100, 1000};

        for (int n : numbers) {
            BigInteger factorial = calculateFactorial(n);
            String first10Digits = getFirst10Digits(factorial);
            System.out.println("First 10 digits of " + n + "! are: " + first10Digits);
        }
    }
    
    public static BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static String getFirst10Digits(BigInteger number) {
        String numberString = number.toString();
        return numberString.substring(0, Math.min(10, numberString.length()));
    }
}

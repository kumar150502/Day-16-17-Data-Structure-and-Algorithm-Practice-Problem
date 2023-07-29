import java.util.ArrayList;
import java.util.List;
public class PrimeNumbers {
    public static void main(String[] args) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primeNumbers.add(i);
            }
        }

        System.out.println("The prime numbers in the range 0 to 1000 are: ");
        for (int primeNumber : primeNumbers) {
            System.out.println(primeNumber);
        }
    }
}

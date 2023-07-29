import java.util.ArrayList;
import java.util.List;
public class Permutations {
    public static List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i);
            String suffix = str.substring(i + 1);
            List<String> subPermutations = getPermutations(suffix);
            for (String subPermutation : subPermutations) {
                permutations.add(prefix + subPermutation);
            }
        }

        return permutations;
    }

    public static List<String> getPermutationsRecursive(String str) {
        if (str.length() == 0) {
            return List.of("");
        }

        List<String> permutations = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i);
            String suffix = str.substring(i + 1);
            List<String> subPermutations = getPermutationsRecursive(suffix);
            for (String subPermutation : subPermutations) {
                permutations.add(prefix + subPermutation);
            }
        }

        return permutations;
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> permutations = getPermutations(str);
        List<String> recursivePermutations = getPermutationsRecursive(str);
        assert permutations.equals(recursivePermutations);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}

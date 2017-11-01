import java.util.*;
public class UniqueSubstrings {
    public String[] uniqueSubstrings(String s, int k) {
        int j = k;
        HashSet<String> hash = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            hash.add(s.substring(i, j));
            j++;
        }
        String[] results = hash.toArray(new String[s.length()]);
        Arrays.sort(results);

        return results;
    }
    public static void main(String[] args) {
        UniqueSubstrings u = new UniqueSubstrings();
        String[] s = u.uniqueSubstrings("caaab", 2);
        System.out.println(s);
    }
}

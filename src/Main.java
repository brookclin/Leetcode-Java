import java.util.Stack;

class Solution {
    public String addBinary(String a, String b) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            carry = sum / 2;
            sum = sum % 2;
            sb.append(sum);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String answer = sol.addBinary("111110000", "111111");
        System.out.println(answer);
    }
}

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();

        int count = 0;
        int i = 0;

        while (i < num.length()) {
            int n = num.charAt(i) - '0';

            while (!st.isEmpty() && st.peek() > n && count < k) {
                st.pop();
                count++;
            }

            st.push(n);
            i++;
        }

        // If removals are still left, remove from the end
        while (count < k) {
            st.pop();
            count++;
        }

        StringBuilder sb = new StringBuilder();

        for (int digit : st) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
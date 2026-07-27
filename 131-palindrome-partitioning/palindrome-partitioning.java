import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtrack(0, s, path, ans);

        return ans;
    }

    private void backtrack(int start, String s,
                           List<String> path,
                           List<List<String>> ans) {

        // Base Case
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            // Check if current substring is palindrome
            if (isPalindrome(s, start, end)) {

                // Choose
                path.add(s.substring(start, end + 1));

                // Explore
                backtrack(end + 1, s, path, ans);

                // Backtrac
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
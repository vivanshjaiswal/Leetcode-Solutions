class Solution {
    public String simplifyPath(String path) {
        java.util.Stack<String> st = new java.util.Stack<>();
        String temp = "";
        for (int i = 0; i <= path.length(); i++) {
            if (i == path.length() || path.charAt(i) == '/') {
                if (temp.equals("") || temp.equals(".")) {
                } else if (temp.equals("..")) {
                    if (!st.isEmpty()) st.pop();
                } else {
                    st.push(temp);
                }
                temp = "";
            } else {
                temp += path.charAt(i);
            }
        }
        java.util.List<String> res = new java.util.ArrayList<>();
        while (!st.isEmpty()) {
            res.add(st.pop());
        }
        java.util.Collections.reverse(res);
        StringBuilder ans = new StringBuilder();
        for (String dir : res) {
            ans.append("/").append(dir);
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}
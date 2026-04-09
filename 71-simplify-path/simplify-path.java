class Solution {
    public String simplifyPath(String path) {
        java.util.List<String> dirs = new java.util.ArrayList<>();
        String temp = "";
        for (int i = 0; i <= path.length(); i++) {
            if (i == path.length() || path.charAt(i) == '/') {
                if (temp.equals("") || temp.equals(".")) {
                } else if (temp.equals("..")) {
                    if (!dirs.isEmpty()) dirs.remove(dirs.size() - 1);
                } else {
                    dirs.add(temp);
                }
                temp = "";
            } else {
                temp += path.charAt(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String dir : dirs) {
            res.append("/").append(dir);
        }
        return res.length() == 0 ? "/" : res.toString();
    }
}
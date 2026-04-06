class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '#'){
                sb.append(s.charAt(i));
            } else {
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        StringBuilder sc = new StringBuilder();
        
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) != '#'){
                sc.append(t.charAt(i));
            } else {
                if(sc.length() > 0){
                    sc.deleteCharAt(sc.length() - 1);
                }
            }
        }

        return sb.toString().equals(sc.toString());
    }
}
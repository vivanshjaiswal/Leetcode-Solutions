class Solution {
    // static final int INT_MIN_VAL = -2147483648;
    //     static final int INT_MAX_VAL = 2147483647;
    private int helper(String s,long nums,int i,int sign){
        
        if(i>=s.length() || !Character.isDigit(s.charAt(i))){
            return (int)(sign*nums);
        }
        nums=nums*10+s.charAt(i)-'0';
        
        if (sign == 1 && nums > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sign == -1 && -nums < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return helper(s,nums,i+1,sign);
    }
    public int myAtoi(String s) {
        int i=0;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        int sign=1;
        if(i<s.length() && (s.charAt(i)=='+'||s.charAt(i)=='-')){
            sign=(s.charAt(i)=='-')?-1:1;
            i++;
        }
        return helper(s,0,i,sign);
    }
}
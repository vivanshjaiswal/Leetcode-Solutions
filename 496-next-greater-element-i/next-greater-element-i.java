class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int negative[]=new int [nums1.length];
        //Using monotonnic stack and hash map:=
        Stack<Integer> S = new Stack<>();
        HashMap<Integer,Integer>next=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            while(!S.isEmpty() && nums2[i]>S.peek()){
                next.put(S.pop(),nums2[i]);
            }
            S.push(nums2[i]);
        }
        while(!S.isEmpty()){
            next.put(S.pop(),-1);
        }
        for(int i=0;i<nums1.length;i++){
           negative[i]=next.get(nums1[i]);
        }
        
        return negative;
    }
}

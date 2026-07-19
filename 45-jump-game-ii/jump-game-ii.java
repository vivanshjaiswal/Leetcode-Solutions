class Solution {
    public int jump(int[] nums) {
        int boundary=0;
        int hopsdestination=0;
        int jump=0;
        for(int i=0;i<nums.length-1;i++){
            hopsdestination=Math.max(hopsdestination,i+nums[i]);
            if(i==boundary){
                jump++;
                boundary=hopsdestination;
            }
        }
        return jump;
    }
}
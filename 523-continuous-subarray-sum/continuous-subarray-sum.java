class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum=0;
        int n=nums.length;
        
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
           int remainder=sum%k;
            if(map.containsKey(remainder)){
                if(i-map.get(remainder)>=2){
                    return true;
                }
                
            }
            else{
                    map.put(remainder,i);
                    
                }
       
        }
        return false;
        
    }
}
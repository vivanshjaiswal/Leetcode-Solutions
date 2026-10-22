class Solution {
    public int maxArea(int[] height) {
        int ht=0;
        int width=0;
        int maxWater=0;
        int water=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            ht=Math.min(height[left],height[right]);
            width=right-left;
            water=ht*width;
            maxWater=Math.max(water,maxWater);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }


        }
        return maxWater;
    }
}
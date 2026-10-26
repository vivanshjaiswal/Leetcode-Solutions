
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //Brute Force Approach -

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

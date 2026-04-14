class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            boolean forward = nums[i] > 0;
            int slow = i, fast = i;

            while (true) {
                slow = getNext(nums, forward, slow);
                fast = getNext(nums, forward, fast);
                if (fast != -1) fast = getNext(nums, forward, fast);

                if (slow == -1 || fast == -1) break;

                if (slow == fast) {
                    if (slow == getNext(nums, forward, slow)) break;
                    return true;
                }
            }

            int index = i;
            while (nums[index] != 0) {
                int next = (index + nums[index]) % n;
                if (next < 0) next += n;
                nums[index] = 0;
                index = i;
            }
        }
        return false;
    }

    private int getNext(int[] nums, boolean forward, int index) {
        boolean direction = nums[index] > 0;
        if (direction != forward) return -1;

        int n = nums.length;
        int next = (index + nums[index]) % n;
        if (next < 0) next += n;

        if (next == index) return -1;

        return next;
    }
}
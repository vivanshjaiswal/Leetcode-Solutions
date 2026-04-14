class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean forward = nums[i] > 0;
            Set<Integer> visited = new HashSet<>();
            int current = i;

            while (true) {
                if ((nums[current] > 0) != forward) break;

                if (visited.contains(current)) {
                    return true;
                }

                visited.add(current);

                int next = (current + nums[current]) % n;
                if (next < 0) next += n;

                if (next == current) break;

                current = next;
            }
        }
        return false;
    }
}
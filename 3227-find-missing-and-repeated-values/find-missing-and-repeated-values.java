
import java.util.HashMap;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = grid.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                sum += num;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int repeat = -1;

        for (int num : map.keySet()) {
            if (map.get(num) == 2) {
                repeat = num;
                break;
            }
        }

        int total = n * n;
        int expectedSum = total * (total + 1) / 2;
        int missing = expectedSum - sum + repeat;

        return new int[]{repeat, missing};
    }
}
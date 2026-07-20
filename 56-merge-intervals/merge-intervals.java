import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> mergedIntervals = new ArrayList<>();

        if (intervals.length == 0) {
            return new int[0][];
        }

        // Sort according to start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] tempInterval = intervals[0];

        for (int[] it : intervals) {

            // Overlapping interval
            if (it[0] <= tempInterval[1]) {
                tempInterval[1] = Math.max(it[1], tempInterval[1]);
            }
            // Non-overlapping interval
            else {
                mergedIntervals.add(tempInterval);
                tempInterval = it;
            }
        }

        // Last interval add karna mat bhoolna
        mergedIntervals.add(tempInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
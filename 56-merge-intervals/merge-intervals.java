
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            list.add(new int[]{interval[0], interval[1]});
        }

        boolean merged = true;

        while (merged) {
            merged = false;

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int[] a = list.get(i);
                    int[] b = list.get(j);

                    if (a[0] <= b[1] && b[0] <= a[1]) {
                        a[0] = Math.min(a[0], b[0]);
                        a[1] = Math.max(a[1], b[1]);

                        list.remove(j);
                        merged = true;
                        break;
                    }
                }

                if (merged) {
                    break;
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}

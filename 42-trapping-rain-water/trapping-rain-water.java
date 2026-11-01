import java.util.*;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        Stack<Integer> heights = new Stack<>();

        for (int i = 0; i < n; i++) {
 while (!heights.isEmpty() && height[i] > height[heights.peek()]) {
                int top = heights.pop();

                if (heights.isEmpty()) break;

                int left = heights.peek();  
                int width = i - left - 1;
    int boundedHeight = Math.min(height[left], height[i]) - height[top];

                water += width * boundedHeight;
            }
            heights.push(i);
        }

        return water;
    }
}
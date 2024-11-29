package 릿코드;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q11 {
    public int maxArea(int[] h) {
        int max = 0;
        int start = 0;
        int end = h.length - 1;
        while (start < end) {
            int now = (end - start) * Math.min(h[start], h[end]);
            max = Math.max(max, now);
            if (h[start] >= h[end]) {
                end--;
            } else {
                start++;
            }
        }
        return max;

    }
}

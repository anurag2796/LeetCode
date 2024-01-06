package strings.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;
        if (s.length() == 1)
            return 1;
        int max = 0;
        int[] count = new int[256]; // Increased size to handle all ASCII characters
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
            q.add(c);
            while (count[c] > 1) {
                char removed = q.poll();
                count[removed]--;
            }
            max = Math.max(max, q.size());
        }
        return max;
    }
}

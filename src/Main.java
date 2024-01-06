import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Main m = new Main();
        System.out.println(m.lengthOfLongestSubstring("pwwkew")); //2
        System.out.println(m.lengthOfLongestSubstring("bbbbb"));  //1
        System.out.println(m.lengthOfLongestSubstring("asdfghjk"));  //8
        System.out.println(m.lengthOfLongestSubstring("ksdkasdf"));  //5

    }

    public int lengthOfLongestSubstring1(String s) throws NullPointerException {

        if(s.isEmpty())
            return 0;
        if(s.length() == 1)
            return 1;
        int max= 0;
        int maxCurr=0;
        int count[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i= 0;i< s.length();i++){
            if(count[s.charAt(i)-97] == 0){
                count[s.charAt(i)-97]++;
                q.add(s.charAt(i));
                maxCurr++;
            }
            else{
                max = Math.max(max, maxCurr);
                while (!q.poll().equals(s.charAt(i))){
                  maxCurr--;
                  count[s.charAt(i)-97]--;
                }
                maxCurr--;
                count[q.poll()-97]--;
            }
        }
        return max;

    }

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
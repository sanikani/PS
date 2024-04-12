import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new CustomComparator(n));
        return strings;
    }
}

class CustomComparator implements Comparator<String> {
    int n;
    
    public CustomComparator(int n) {
        this.n = n;
    }

    @Override
    public int compare(String o1, String o2) {
        int result = o1.charAt(n) - o2.charAt(n);
        if (result == 0) {
            return o1.compareTo(o2);
        }
        return result;
    }
}
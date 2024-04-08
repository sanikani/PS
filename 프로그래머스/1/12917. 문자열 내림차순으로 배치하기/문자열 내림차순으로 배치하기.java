import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s) {
        String arr[] = s.split("");
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(Arrays.stream(arr).collect(Collectors.joining()));
        return sb.reverse().toString();
    }
}
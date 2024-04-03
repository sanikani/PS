import java.util.*;
import java.util.stream.*;
class Solution {
    public long solution(long n) {
        String arr[] = String.valueOf(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        String answer = Arrays.stream(arr).collect(Collectors.joining());
        return Long.parseLong(answer);
        }
}
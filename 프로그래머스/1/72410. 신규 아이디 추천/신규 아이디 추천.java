import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String new_id) {
        String step1 = new_id.toLowerCase();

        String step2 = step1.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> Character.isLetterOrDigit(ch) || ch == '-' || ch == '_' || ch == '.')
                .map(String::valueOf)
                .collect(Collectors.joining());

        String step3 = IntStream.range(0, step2.length())
                .mapToObj(i -> (i > 0 && step2.charAt(i) == '.' && step2.charAt(i - 1) == '.') ? "" : String.valueOf(step2.charAt(i)))
                .collect(Collectors.joining());

        String step4 = step3;
        if (step4.length() > 0 && step4.charAt(0) == '.') {
            step4 = step4.substring(1);
        }
        if (step4.length() > 0 && step4.charAt(step4.length() - 1) == '.') {
            step4 = step4.substring(0, step4.length() - 1);
        }

        String step5 = step4.isEmpty() ? "a" : step4;

        String step6 = step5.length() > 15 ? 
                step5.substring(0, 15).chars()
                        .mapToObj(ch -> (char) ch)
                        .limit(step5.charAt(14) == '.' ? 14 : 15)
                        .map(String::valueOf)
                        .collect(Collectors.joining()) : step5;

        String step7 = step6.length() <= 2 ?
                step6 + String.valueOf(step6.charAt(step6.length() - 1)).repeat(3 - step6.length()) : step6;

        return step7;
    }
}
    
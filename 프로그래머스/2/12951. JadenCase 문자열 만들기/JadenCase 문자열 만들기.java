import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isNewWord = true; // 단어의 시작을 확인하는 플래그

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                isNewWord = true; // 공백 이후는 새로운 단어의 시작
            } else {
                if (isNewWord && Character.isAlphabetic(c)) {
                    sb.append(Character.toUpperCase(c)); // 단어의 첫 문자 대문자
                } else {
                    sb.append(Character.toLowerCase(c)); // 나머지 문자는 소문자
                }
                isNewWord = false; // 단어의 시작이 아님을 표시
            }
        }

        return sb.toString();
    }
}

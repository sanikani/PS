package 코딩테스트입문;

import java.util.ArrayList;
import java.util.List;

public class 잘라서배열로저장 {
    public String[] solution(String my_str, int n) {
        List<String> list = new ArrayList<>();
        int cursor = 0;
        while (cursor < my_str.length()) {
            if (my_str.length() - cursor > n) {
                list.add(my_str.substring(cursor, cursor + n));
                cursor += n;
            } else {
                list.add(my_str.substring(cursor));
                break;
            }
        }
        return list.toArray(new String[0]);
    }
}

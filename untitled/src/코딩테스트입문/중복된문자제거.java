package 코딩테스트입문;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 중복된문자제거 {
    public String solution(String my_string) {
        return Stream.of(my_string.split(""))
                .distinct()
                .collect(Collectors.joining());
    }
}

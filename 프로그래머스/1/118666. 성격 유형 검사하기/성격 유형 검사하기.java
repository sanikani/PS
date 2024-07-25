import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scores = IntStream.range(0, survey.length)
            .boxed()
            .flatMap(i -> {
                char type1 = survey[i].charAt(0);
                char type2 = survey[i].charAt(1);
                int score = choices[i] - 4;
                if (score < 0) {
                    return Stream.of(new AbstractMap.SimpleEntry<>(type1, -score));
                } else if (score > 0) {
                    return Stream.of(new AbstractMap.SimpleEntry<>(type2, score));
                }
                return Stream.empty();
            })
            .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));

        return "RCJA".chars()
            .mapToObj(c -> (char) c)
            .map(c -> {
                char opposite = getOpposite(c);
                return scores.getOrDefault(c, 0) >= scores.getOrDefault(opposite, 0) ? c : opposite;
            })
            .map(String::valueOf)
            .collect(Collectors.joining());
    }

    private char getOpposite(char c) {
        switch (c) {
            case 'R': return 'T';
            case 'C': return 'F';
            case 'J': return 'M';
            case 'A': return 'N';
            default: throw new IllegalArgumentException("Invalid character: " + c);
        }
    }
}
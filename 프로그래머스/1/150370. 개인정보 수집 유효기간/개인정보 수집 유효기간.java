import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : terms){
            String[] tmp = s.split(" ");
            map.put(tmp[0], Integer.valueOf(tmp[1]));
        }
        int index = 1;
        for(String s : privacies){
            String[] tmp = s.split(" ");
            String[] d = tmp[0].split("\\.");
            Date date = new Date(Integer.valueOf(d[0]),Integer.valueOf(d[1]),Integer.valueOf(d[2]));
            if(date.isOver(today,map.get(tmp[1]))) answer.add(index);
            index++;
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    class Date {
        int year;
        int month;
        int day;
        
        public Date(int year, int month, int day){
            this.year = year;
            this.month = month;
            this.day = day;
        }
        
        public boolean isOver(String today, int termMonths) {
            month += termMonths;
            while (month > 12) {
                month -= 12;
                year++;
            }
            day -= 1;
            if (day == 0) {
                month -= 1;
                if (month == 0) {
                    month = 12;
                    year -= 1;
                }
                day = 28;
            }
            
            String[] tmp = today.split("\\.");
            int todayYear = Integer.valueOf(tmp[0]);
            int todayMonth = Integer.valueOf(tmp[1]);
            int todayDay = Integer.valueOf(tmp[2]);

            if (year < todayYear) {
                return true;
            } else if (year == todayYear) {
                if (month < todayMonth) {
                    return true;
                } else if (month == todayMonth) {
                    return day < todayDay;
                }
            }
            return false;
        }
    }
}
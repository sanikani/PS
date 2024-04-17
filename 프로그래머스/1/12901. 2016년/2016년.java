import java.util.*;
import java.text.*;

class Solution {
    public String solution(int a, int b) {
        try {
            String date1 = "2016/01/01";
            String date2 = "2016/" + a + "/" + b;
            Date d1 = new SimpleDateFormat("yyyy/MM/dd").parse(date1);
            Date d2 = new SimpleDateFormat("yyyy/MM/dd").parse(date2);
            long diffSec = (d2.getTime() - d1.getTime()) / 1000;
            long diffDays = diffSec / (24 * 60 * 60);
            int dayOfWeek = (int) (diffDays % 7);
            switch (dayOfWeek) {
                case 0: return "FRI";
                case 1: return "SAT";
                case 2: return "SUN";
                case 3: return "MON";
                case 4: return "TUE";
                case 5: return "WED";
                case 6: return "THU";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}

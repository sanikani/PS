class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int video_lenSec = toSecond(video_len);
        int posSec = toSecond(pos);
        int op_startSec = toSecond(op_start);
        int op_endSec = toSecond(op_end);
        if(isOpening(posSec, op_startSec, op_endSec)){
                    posSec = op_endSec;
        }
        for(int i=0;i<commands.length;i++){
            if(commands[i].equals("prev")){
                posSec -= 10;
                if(posSec<0){
                    posSec = 0;
                }
                if(isOpening(posSec, op_startSec, op_endSec)){
                    posSec = op_endSec;
                }
            }else{
                posSec += 10;
                if(posSec>video_lenSec){
                    posSec = video_lenSec;
                }
                if(isOpening(posSec, op_startSec, op_endSec)){
                    posSec = op_endSec;
                }
            }
        }
        return toFormat(posSec);
    }
    
    int toSecond(String time){
        int second = 0;
        String[] arr = time.split(":");
        second += Integer.valueOf(arr[0])*60;
        second += Integer.valueOf(arr[1]);
        return second;
    }
    
    boolean isOpening(int pos, int op_start, int op_end){
        return pos>=op_start && pos<=op_end;
    }
    
    String toFormat(int time){
        String format="";
        int min = time/60;
        if(min<10){
            format+="0"+min+":";
        }else{
            format += min+":";
        }
        int sec = time%60;
        if(sec<10){
            format+="0"+sec;
        }else{
            format+=sec;
        }
        return format;
    }
}
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int result = 0;
        for(int i=0;i<schedules.length;i++){
            int time = schedules[i] + 10;
            if(time%100 >= 60){
                time = time + 40;
            }
            int idx = startday;
            //System.out.println("직원"+i+"희망시간"+time);
            int cnt = 0;
            for(int j=0;j<7;j++){
                if(idx == 6 || idx == 7 || idx == 13){
                    idx++;
                    continue;
                }
                //System.out.println("직원"+i+","+idx+"요일"+"출근시간"+timelogs[i][j]);
                if(timelogs[i][j]>time){
                    break;
                }
                idx++;
                cnt++;
            }
            if(cnt == 5){
                result++;
            }
        }
        return result;
    }
}
package 코딩테스트입문;

public class 이차원으로만들기 {
    public int[][] solution(int[] num_list, int n) {

        int[][] answer = new int[num_list.length/n][n];
        int cnt=0;
        for(int i=0; i<num_list.length/n;i++){
            for(int j=0;j<n;j++){
                answer[i][j] = num_list[cnt];
                cnt++;
            }
        }
        return answer;
    }
}


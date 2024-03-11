package section09;

import java.io.*;
        import java.util.*;
public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        회의실배정 T = new 회의실배정();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        System.out.println(T.solution(list));
    }

    private int solution(List<Meeting> list) {
        int answer = 0;
        Collections.sort(list);
        int end = -1;
        for (Meeting meeting : list) {
            if (meeting.s >= end) {
                end = meeting.e;
                answer++;
            }
        }
        return answer;
    }

    public static class Meeting implements Comparable<Meeting>{
        int s;
        int e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.e == o.e) {
                return this.s - o.s;
            }
            return this.e-o.e;
        }
    }
}

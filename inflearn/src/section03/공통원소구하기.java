package section03;

import java.util.*;

public class 공통원소구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arrA = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arrB = new int[m];
        for (int j = 0; j < m; j++) {
            arrB[j] = in.nextInt();
        }
        for (int x : solution(n, m, arrA, arrB)) {
            System.out.print(x+" ");
        }
    }

    private static List<Integer> solution(int n, int m, int[] arrA, int[] arrB) {
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        List<Integer> list = new ArrayList<>();
        int idxA = 0;
        int idxB = 0;
        while (idxA < n && idxB < m) {
            if (arrA[idxA] == arrB[idxB]) {
                list.add(arrA[idxA++]);
                idxB++;
            } else if (arrA[idxA] < arrB[idxB]) {
                idxA++;
            } else if (arrA[idxA] > arrB[idxB]) {
                idxB++;
            }
        }
        return list;
    }
}

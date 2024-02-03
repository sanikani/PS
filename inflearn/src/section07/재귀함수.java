package section07;

public class 재귀함수 {
    public static void main(String[] args) {
        재귀함수 T = new 재귀함수();
        T.DFS(3);
    }

    public void DFS(int n) {
        if (n < 1) {
            return;
        }
        DFS(n - 1);
        System.out.println(n);

    }
}

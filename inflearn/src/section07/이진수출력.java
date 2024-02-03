package section07;

public class 이진수출력 {
    public static void main(String[] args) {
        이진수출력 T = new 이진수출력();
        T.DFS(11);
    }

    private void DFS(int i) {
        if (i == 0) {
            return;
        }
            DFS(i/2);
            System.out.print(i%2);

    }
}

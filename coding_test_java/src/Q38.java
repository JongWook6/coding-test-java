public class Q38 {

    private static boolean[] visited;
    private static int[][] computer;

    private static void bfs(int now) {
        visited[now] = true;
        for (int i = 0; i < computer[now].length; i++) {
            if (computer[now][i] == 1 && !visited[i]) {
                bfs(i);
            }
        }
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        computer = computers;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = solution(3, computers);
        System.out.println("answer = " + answer);
    }
}

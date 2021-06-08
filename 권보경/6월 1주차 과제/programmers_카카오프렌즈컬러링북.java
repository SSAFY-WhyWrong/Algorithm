import java.util.*;

class Solution {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static boolean[][] visited;
    static Queue<Point> queue;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    // bfs Å½»ö
                    numberOfArea++;
                    int tmp = 0;
                    queue = new LinkedList<>();
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Point now = queue.poll();
                        tmp++;
                        for (int d = 0; d < 4; d++) {
                            int nx = now.x + dx[d];
                            int ny = now.y + dy[d];

                            if (0 > nx || nx >= m || 0 > ny || ny >= n)
                                continue;
                            if (picture[nx][ny] != picture[now.x][now.y] || visited[nx][ny])
                                continue;
                            queue.offer(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }

                    if (tmp > maxSizeOfOneArea)
                        maxSizeOfOneArea = tmp;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
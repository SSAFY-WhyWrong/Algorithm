import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj16197 {

    static int n, m;
    static char[][] map;
    static Queue<Point> queue;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        queue = new LinkedList<Point>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'o')
                    queue.offer(new Point(i, j, 0));
            }
        }

        System.out.println(bfs());

    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Point coin1 = queue.poll();
            Point coin2 = queue.poll();

            if (coin1.t > 10)
                return -1;

            for (int d = 0; d < 4; d++) {
                int x1 = coin1.x + dx[d];
                int y1 = coin1.y + dy[d];
                int x2 = coin2.x + dx[d];
                int y2 = coin2.y + dy[d];

                // true : 떨어진 경우. false : 떨어지지 않은 경우
                boolean check1 = fallCheck(x1, y1);
                boolean check2 = fallCheck(x2, y2);

                if (check1 && check2) { // 둘 다 떨어진 경우
                    continue;
                }

                if ((check1 && !check2) || (!check1 && check2)) { // 하나만 떨어진 경우
                    // System.out.println("하나만 떨어졌음");
                    return (coin1.t + 1) > 10 ? -1 : (coin1.t + 1);
                }

                if (map[x1][y1] == '#') {
                    x1 -= dx[d];
                    y1 -= dy[d];
                }

                if (map[x2][y2] == '#') {
                    x2 -= dx[d];
                    y2 -= dy[d];
                }

                queue.offer(new Point(x1, y1, coin1.t + 1));
                queue.offer(new Point(x2, y2, coin2.t + 1));
            }
        }
        return -1;
    }

    public static boolean fallCheck(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < m)
            return false;
        return true;
    }

    static class Point {
        int x, y, t;

        public Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
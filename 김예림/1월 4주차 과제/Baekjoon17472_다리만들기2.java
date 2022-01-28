package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon17472_다리만들기2 {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int N, M;
    static int[] parent;
    static int[][] map;
    static boolean[][] visited;
    static Queue<IslandInfo> queue = new LinkedList<>();
    static PriorityQueue<IslandInfo> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int island = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==1 && !visited[i][j]) {
                    visited[i][j] = true;
                    map[i][j] = island+1;
                    dfs(i, j, island+1);
                    island++;
                    queue.add(new IslandInfo(i, j, map[i][j], -1, 0));
                }
            }
        }

        while(!queue.isEmpty()) {
            bfs(queue.poll(), island);
        }

        parent = new int[island+1];
        for(int i=1; i<=island; i++)
            parent[i] = i;

        int ans = 0;
        int cnt = 0;

        while(!pq.isEmpty()) {
            IslandInfo temp = pq.poll();

            int x = temp.x;
            int y = temp.y;

            if(find(x)==find(y)) continue;

            union(x, y);

            cnt++;
            ans += temp.cnt;
        }

        if(cnt==island-1) System.out.println(ans);
        else System.out.println(-1);
    }

    public static void bfs(IslandInfo start, int island) {
        Queue<IslandInfo> queue = new LinkedList<>();
        boolean[][] v = new boolean[N][M];
        boolean[] v2 = new boolean[island+1];
        queue.add(new IslandInfo(start.x, start.y, start.num, -1, 0));
        v[start.x][start.y] = true;

        while(!queue.isEmpty()) {
            IslandInfo temp = queue.poll();

            if(temp.idx==-1) {
                for(int d=0; d<4; d++) {
                    int ni = temp.x+di[d];
                    int nj = temp.y+dj[d];

                    if(ni<0 || ni>=N || nj<0 || nj>=M || v[ni][nj]) continue;

                    v[ni][nj] = true;

                    if(map[ni][nj]==0) {
                        queue.add(new IslandInfo(ni, nj, temp.num, d, temp.cnt+1));
                    }else {
                        if(map[ni][nj]!=temp.num && !v2[map[ni][nj]] && temp.cnt>=2) {
                            v2[map[ni][nj]] = true;
                            pq.add(new IslandInfo(temp.num, map[ni][nj], 0, 0, temp.cnt));
                        }
                    }
                }
            }else {
                int ni = temp.x+di[temp.idx];
                int nj = temp.y+dj[temp.idx];

                if(ni<0 || ni>=N || nj<0 || nj>=M || v[ni][nj]) continue;

                v[ni][nj] = true;

                if(map[ni][nj]==0) { 
                    queue.add(new IslandInfo(ni, nj, temp.num, temp.idx, temp.cnt+1));
                }else {
                    if(map[ni][nj]!=temp.num && !v2[map[ni][nj]] && temp.cnt>=2) {
                        v2[map[ni][nj]] = true;
                        pq.add(new IslandInfo(temp.num, map[ni][nj], 0, 0, temp.cnt));
                    }
                }
            }
        }
    }

    public static void dfs(int i, int j, int num) {
        for(int d=0; d<4; d++) {
            int ni = i+di[d];
            int nj = j+dj[d];

            if(ni<0 || ni>=N || nj<0 || nj>=M || visited[ni][nj] || map[ni][nj]!=1) continue;

            visited[ni][nj] = true;
            map[ni][nj] = num;
            queue.add(new IslandInfo(ni, nj, num, -1, 0));
            dfs(ni, nj, num);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    public static int find(int a) {
        if(parent[a]==a)
            return a;
        return parent[a] = find(parent[a]);
    }

    public static class IslandInfo implements Comparable<IslandInfo>{
        int x;
        int y;
        int num;
        int idx;
        int cnt;
        public IslandInfo(int x, int y, int num, int idx, int cnt) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.idx = idx;
            this.cnt = cnt;
        }
        public int compareTo(IslandInfo p) {
            return this.cnt > p.cnt ? 1 : -1;
        }
    }
}
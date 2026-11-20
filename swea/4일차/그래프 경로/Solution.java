import java.io.*;
import java.util.*;

class Solution {
    static int[][] graph;
    static boolean[] visited;
    static int S, G;
    
    // 단방향 DFS 경로가 있는지 확인하는 함수
    static boolean dfs(int cur) {
        if (cur == G) return true;
        visited[cur] = true;

        for (int i = 1; i < graph.length; i++) {
            if (graph[cur][i] == 1 && !visited[i]) {
                if (dfs(i)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new int[V+1][V+1];
            visited = new boolean[V+1];
            
            // 그래프 채우기
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());

            int answer = 0;
            if (dfs(S)) answer = 1;

            System.out.println("#" + tc + " " + answer);
        }
    }
}
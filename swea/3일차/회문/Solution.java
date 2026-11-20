import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] dic = new char[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();

                for (int j = 0; j < N; j++) {
                    dic[i][j] = line.charAt(j);
                }
            }

            String answer = "";
            boolean found = false;

            // 가로 회문
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N-M; j++) {
                    int left = j;
                    int right = j + M - 1;
                    boolean pan = true;

                    while (left < right) {
                        if (dic[i][left] != dic[i][right]) {
                            pan = false;
                            break;
                        }
                        left++;
                        right--;
                    }
                    
                    if (pan) {
                        for (int k = j; k < j + M; k++) {
                            answer += dic[i][k];
                        }
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            // 세로 회문
            if (!found) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j <= N-M; j++) {

                        int top = j;
                        int bottom = j + M - 1;
                        boolean pan = true;

                        while (top < bottom) {
                            if (dic[top][i] != dic[bottom][i]) {
                                pan = false;
                                break;
                            }
                            top++;
                            bottom--;
                        }

                        if (pan) {
                            for (int k = j; k < j + M; k++) {
                                answer += dic[k][i];
                            }
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
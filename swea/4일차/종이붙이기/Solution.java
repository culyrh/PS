import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int n = N / 10;
            int[] dp = new int[n+2];
            dp[1] = 1;
            dp[2] = 3;
            
            // dp[i] = 끝 10칸을 세로 1장으로 채움(1*dp[i-1])
            //         + 전 모양에서 끝 20칸을 (1)가로 2장 (2)큰네모 1장으로 채움(2*dp[i-2])
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i-1] + 2*dp[i-2];
            }
            System.out.println("#" + tc + " " + dp[n]);
        }
    }
}
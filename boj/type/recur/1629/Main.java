import java.io.*;
import java.util.*;

public class Main {

    static long A, B, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    static long pow(long a, long b) {
        
        // 재귀호출 종료 조건
        if (b == 1) {
            return a % C;
        }

        // a^(b/2)를 재귀로 계산
        long half = pow(a, b / 2);

        if (b % 2 == 0) {
            // b가 짝수
            return (half * half) % C;
        } else {
            // b가 홀수 -> a를 한번 더 곱해서 보정
            return (half * half % C) * a % C;
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[][] commands = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            commands[i][0] = Integer.parseInt(st.nextToken());
            commands[i][1] = Integer.parseInt(st.nextToken());
            commands[i][2] = Integer.parseInt(st.nextToken());
        }
        
        // 풀이
        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int pos = commands[i][2];

            int[] temp = new int[end - start + 1];
            int idx = 0;

            for (int j = start - 1; j <= end - 1; j++) {
                temp[idx++] = array[j];
            }

            Arrays.sort(temp);
            answer[i] = temp[pos - 1];
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
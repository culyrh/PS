import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());
    	    int M = Integer.parseInt(st.nextToken());
           
            int[] arr = new int[N];
            
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
            	arr[j] = Integer.parseInt(st.nextToken());
             }
             
            int max = 0;
            int min = 0;
            
            for (int k=0; k<N-M+1; k++) {
            	int sum = 0;
                int index = k + M - 1;
            	while(index >= k) {
                	sum += arr[index];
                    index--;
                }
                if (sum < min) min = sum;
                if (sum > max) max = sum;
            }
            System.out.println("#" + (i + 1) + " " + (max - min));
        }
    }
}

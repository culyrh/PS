import java.io.*;
import java.util.*;

class Solution {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			String line = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for (int i=0; i<line.length(); i++) {
				char c = line.charAt(i);
				if (stack.isEmpty()) {
					stack.push(c);
				} else if (c == stack.peek()){ 
					stack.pop();
				} else stack.push(c);
			}
			
			int answer = 0;
			while (!stack.isEmpty()) {
				stack.pop();
				answer++;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
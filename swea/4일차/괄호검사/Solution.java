import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>(); 
            
            int answer = 1;
            
            
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(' || c == '{') {
                    stack.push(c);
                } 
                else if (c == ')' || c == '}') {
                    if (stack.isEmpty()) {
                        answer = 0;
                        break;
                    }
                    char top = stack.pop();

                    if ((c == ')' && top != '(') || (c == '}' && top != '{')) {
                        answer = 0;
                        break;
                    }
                }
            }

            // 짝이 맞지않은 괄호가 남은 경우
            if (!stack.isEmpty()) {
                answer = 0;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
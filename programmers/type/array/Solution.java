import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int pos = commands[i][2];

            int[] temp = new int[end-start+1];

            for (int j=0; j<temp.length; j++) {
                temp[j] = array[start-1];
                start++;
            }
            Arrays.sort(temp);
            answer[i] = temp[pos-1];
        }
        return answer;
    }
}
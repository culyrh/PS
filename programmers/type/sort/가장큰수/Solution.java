import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        // (b+a)가 (a+b)보다 크면 b가 앞, (a+b)가 (b+a)보다 크면 a가 앞

        if (arr[0].equals("0")) {
            return "0";
        }

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }

        return answer;
    }
}
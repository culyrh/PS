import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        // clothes =[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"],
        // ["green_turban", "headgear"]]
        // map = {headgear=2, eyewear=1}
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for (int cnt : map.values()) {
            answer *= (cnt + 1);
        }

        answer -= 1;

        return answer;
    }
}
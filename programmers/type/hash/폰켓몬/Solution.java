import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // (중복 제거 후의 폰켓몬 종류 수, 선택할 수 있는 폰켓몬 수/2)
        answer = Math.min(set.size(), nums.length/2);

        return answer;
        
    }
}

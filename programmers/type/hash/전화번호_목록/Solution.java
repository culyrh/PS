import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashSet<String> set = new HashSet<>();

        for (String phone : phone_book) {
            set.add(phone);
        }

        for (String phone : phone_book) {
            String prefix = "";

            for (int i = 0; i < phone.length(); i++) {
                prefix += phone.charAt(i);
                
                // 순회중인 전호번호(prefix)가 hashset에 존재하고, 
                // 현재 순회중인 전화번호가 아닌 경우 answer->false
                if (set.contains(prefix) && !prefix.equals(phone)) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}
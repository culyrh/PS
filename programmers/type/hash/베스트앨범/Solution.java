import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // genres = ["classic", "pop", "classic", "classic", "pop"]
        // plays = [500, 600, 150, 800, 2500]

        // 장르별 총 재생 수
        HashMap<String, Integer> genreMap = new HashMap<>();
        // 장르별 노래 목록
        HashMap<String, ArrayList<Integer>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            genreMap.put(
                genres[i], 
                genreMap.getOrDefault(genres[i], 0) + plays[i]
            );

            // classic -> []
            // classic -> [0, 2, 3]
            songMap.putIfAbsent(genres[i], new ArrayList<>());
            songMap.get(genres[i]).add(i);
        }

        // 장르를 총 재생 수가 많은 순서로 정렬
        ArrayList<String> sortedList = new ArrayList<>(genreMap.keySet());

        sortedList.sort((a, b) ->
            genreMap.get(b) - genreMap.get(a)
        );

        ArrayList<Integer> answerList = new ArrayList<>();

        // 장르별로 노래 정렬 후 재생 수가 많은 최대 2개 선택
        for (String genre : sortedList) {
            
            // songMap 리스트(재생 수) 내림차순 정렬
            songMap.get(genre).sort((a, b) -> {
                if (plays[a] != plays[b]) {
                    return plays[b] - plays[a];
                }
                return a - b;
            });

            answerList.add(songMap.get(genre).get(0));

            // 노래가 2개 이상이면 두 번째 노래도 추가
            if (songMap.get(genre).size() > 1) {
                answerList.add(songMap.get(genre).get(1));
            }
        }

        // ArrayList<Integer> -> int[]
        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}

## (level_3) 베스트앨범

https://school.programmers.co.kr/learn/courses/30/lessons/42579

### 문제 설명

스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

### 제한사항

- genres[i]는 고유번호가 i인 노래의 장르입니다.
- plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
- genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
- 장르 종류는 100개 미만입니다.
- 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
- 모든 장르는 재생된 횟수가 다릅니다.

### 입출력 예

| genres | plays | return |
| --- | --- | --- |
| ["classic", "pop", "classic", "classic", "pop"] | [500, 600, 150, 800, 2500] | [4, 1, 3, 0] |

### 입출력 예 설명

classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

- 고유 번호 3: 800회 재생
- 고유 번호 0: 500회 재생
- 고유 번호 2: 150회 재생

pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

- 고유 번호 4: 2,500회 재생
- 고유 번호 1: 600회 재생

따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.

- 장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시하므로 2번 노래는 수록되지 않습니다.

---

### 풀이 방법

1. `genres`: 노래의 장르 배열, `plays`: 노래별 재생 횟수 배열, `genreMap`: (장르, 총 재생 수) HashMap, `songMap`: (장르, 노래 번호 목록) HashMap
  - `map.get`: 해당 키의 값을 반환
  - `map.put`: 키와 값을 저장하거나 수정
  - `map.getOrDefault()`: 해당 키가 있으면 저장된 값을 반환하고, 없으면 지정한 기본값을 반환
  - `map.putIfAbsent()`: 해당 키가 없을 때만 값을 저장
  - `map.keySet()`: HashMap의 모든 키를 반환

2. 장르를 총 재생 수가 많은 순서로 정렬
  - genreMap의 키(장르)를 ArrayList로 가져온 후 총 재생 수를 기준으로 내림차순 정렬
  - `sortedList.sort()`

3. 각 장르의 노래를 재생 수가 많은 순서로 정렬
  - 재생 수가 같으면 고유 번호가 낮은 순서로 정렬
  - `songMap.get(genre).sort()`

4. 각 장르에서 최대 2개의 노래를 선택
  - 정렬된 노래 목록의 0번째 노래를 추가
  - 노래가 2개 이상이면 1번째 노래도 추가
  - `answerList.add(songMap.get(genre).get(0))`
  - `answerList.add(songMap.get(genre).get(1))`

5. answerList에 저장한 결과를 int[]로 변환하여 반환


```java
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
```

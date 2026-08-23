## (level_2) 전화번호 목록

https://school.programmers.co.kr/learn/courses/30/lessons/42577

### 문제 설명

전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

- 구조대 : 119
- 박준영 : 97 674 223
- 지영석 : 11 9552 4421

전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

### 제한사항

- phone_book의 길이는 1 이상 1,000,000 이하입니다.
  - 각 전화번호의 길이는 1 이상 20 이하입니다.
  - 같은 전화번호가 중복해서 들어있지 않습니다.

### 입출력 예

| phone_book | return |
| --- | --- |
| ["119","97674223","1195524421"] | false |
| ["123","456","789"] | true |
| ["12","123","1235","567","88"] | false |

### 입출력 예 설명

입출력 예 #1
앞에서 설명한 예와 같습니다.

입출력 예 #2
한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.

입출력 예 #3
첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.

---

### 풀이 방법

1. `phone_book`: 전화번호를 담은 배열, `set`: phone_book에서 중복이 제거된 전화번호 종류의 집합(HashSet)
  - `HashSet<Integer> set = new HashSet<>()`
  - `set.add(phone)`: set에 phone 요소 추가

2. phone_book을 phone로 순회하며, 접두어를 의미하는 prefix 선언
  - phone을 다시 `phone.charAt(i)`로 순회하며 접두어를 추가

3. '순회중이 전화번호(prefix)가 hashset에 존재'하고, 그 번호가 현재 순회중인 전화번호가 아닌 경우 false 반환
  - `set.contains(prefix) && !prefix.equals(phone)`


```java
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

```

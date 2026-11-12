## 가장 큰 수

https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=java

### 문제 설명

0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

### 제한사항

- numbers의 길이는 1 이상 100,000 이하입니다.
- numbers의 원소는 0 이상 1,000 이하입니다.
- 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

### 입출력 예

| numbers | return |
| --- | --- |
| [6, 10, 2] | "6210" |
| [3, 30, 34, 5, 9] | "9534330" |

---

### 풀이 방법

- numbers의 모든 숫자를 String.valueOf()로 문자열 변환 (10 -> "10")

- 두 숫자를 각각 AB, BA로 이어 붙여 비교하고, 더 큰 숫자가 만들어지는 순서로 전체 배열을 정렬한다.
```
[10]           → 시작
3 넣기: 10 vs 3 → 310 > 103 → 3이 앞      → [3, 10]
9 넣기: 3 vs 9  → 93 > 39   → 9가 앞      → [9, 3, 10]
2 넣기: 10 vs 2 → 210 > 102 → 2가 앞
        3 vs 2  → 32 > 23   → 3이 앞      → [9, 3, 2, 10]
```

- 결과가 "000"처럼 0으로만 이루어지는 경우 0 반환 (즉 arr[0]이 0인 경우)

- 정렬된 문자열을 전부 이어 붙여 반환한다.

```java
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        // (b+a) - (a+b) > 0 이면 b가 앞, < 0 이면 a가 앞
        // 이 정렬은 a, b가 string일 때만 가능, int는 불가 (compareTo 도 int는 불가능)

        if (arr[0].equals("0")) {
            return "0";
        }

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }

        return answer;
    }
}
```

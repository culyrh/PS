## (level 1) [K번째 수](https://school.programmers.co.kr/learn/courses/30/lessons/42748)

### 문제 설명

배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.

2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.

3. 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

### 제한사항

- array의 길이는 1 이상 100 이하입니다.
- array의 각 원소는 1 이상 100 이하입니다.
- commands의 길이는 1 이상 50 이하입니다.
- commands의 각 원소는 길이가 3입니다.

### 입출력 예

| array | commands | return |
| --- | --- | --- |
| [1, 5, 2, 6, 3, 7, 4] | [[2, 5, 3], [4, 4, 1], [1, 7, 3]] | [5, 6, 3] |

### 입출력 예 설명
[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.

[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.

[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.

---

### 풀이 방법

  - Arrays.sort(arr): arr 배열을 정렬

```java
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
```

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[][] commands = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            commands[i][0] = Integer.parseInt(st.nextToken());
            commands[i][1] = Integer.parseInt(st.nextToken());
            commands[i][2] = Integer.parseInt(st.nextToken());
        }
        
        // 풀이
        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int pos = commands[i][2];

            int[] temp = new int[end - start + 1];
            int idx = 0;

            for (int j = start - 1; j <= end - 1; j++) {
                temp[idx++] = array[j];
            }

            Arrays.sort(temp);
            answer[i] = temp[pos - 1];
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
```
import java.util.TreeSet;
import java.util.Arrays;

class Solution {
    // numbers: 정수 배열
    public int[] solution(int[] numbers) {
        // 중복 제거를 위한 TreeSet 객체 생성
        TreeSet<Integer> set = new TreeSet<>();
        
        // numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[set.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = set.pollFirst();
        }
        
        // 오름차순 정렬
        //Arrays.sort(answer);
        
        return answer;
    }
}
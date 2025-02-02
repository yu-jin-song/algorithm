import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 점수를 저장하기 위한 배열
        int[] score = {0, 0, 0};
        for (int i = 0; i < answers.length; i++) {
            // 1번 수포자
            if (pattern1[i % pattern1.length] == answers[i]) {
                score[0]++;
            }
            
            // 2번 수포자
            if (pattern2[i % pattern2.length] == answers[i]) {
                score[1]++;
            }
            
            // 3번 수포자
            if (pattern3[i % pattern3.length] == answers[i]) {
                score[2]++;
            }
        }
        
        int[] originScore = score.clone();
        Arrays.sort(score);
        int maxScore = score[score.length - 1]; // 최대값 추출
        
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (originScore[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
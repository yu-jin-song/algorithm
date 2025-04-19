import java.util.HashSet;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int n, String[] words) {
        // 이미 사용한 단어들 모음
        HashSet<String> used = new HashSet<>();
        
        // 사람 별 말한 단어 개수 배열
        int[] cnts = new int[n];
        
        // 순서 큐
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < n; i++) {
            queue.add(i);
        }
        
        // 시작자 셋팅
        queue.add(0);
        used.add(words[0]);
        cnts[0]++;
        
        // 현재 단어의 마지막 문자
        char prevLastCh = words[0].charAt(words[0].length() - 1);
        
        int size = words.length;
        for (int i = 1; i < size; i++) {
            // 만약 배열의 단어를 모두 사용했다면 맨 처음으로 돌아감
            if (i == size) {
                i = 0;
            }
            
            int participant = queue.poll();
            // 현재 참가자의 차례를 증가
            cnts[participant]++;
            
            // 이미 등장한 단어거나 앞 사람이 말한 단어의 마지막 문자로 시작할 수 없다면
            if (used.contains(words[i]) || prevLastCh != words[i].charAt(0)) {
                return new int[] {participant + 1, cnts[participant]};
            }
            
            used.add(words[i]);
            queue.add(participant);
            prevLastCh = words[i].charAt(words[i].length() - 1);
        }
        
        // 탈락자가 발생하지 않았으므로 [0, 0] 반환
        return new int[] {0, 0};
    }
}
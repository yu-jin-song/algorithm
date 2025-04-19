import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        // 이미 사용한 단어들 모음
        HashSet<String> used = new HashSet<>();
        
        // 현재 단어의 마지막 문자 초기화(현재는 첫 단어의 첫 문자)
        char prevLastCh = words[0].charAt(0);
        
        int size = words.length;
        for (int i = 0; i < size; i++) {
            // 이미 등장한 단어거나 앞 사람이 말한 단어의 마지막 문자로 시작할 수 없다면
            if (used.contains(words[i]) || prevLastCh != words[i].charAt(0)) {
                return new int[] {(i % n) + 1 , (i / n) + 1};
            }
            
            used.add(words[i]);
            prevLastCh = words[i].charAt(words[i].length() - 1);
        }
        
        // 탈락자가 발생하지 않았으므로 [0, 0] 반환
        return new int[] {0, 0};
    }
}
// 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용한다. -> queue
// 한 번 사용한 카드는 다시 사용할 수 없다.
// 카드를 사용하지 않고 다음 카드로 넘어갈 수 없다.
// 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없다.

// O(N^3)까지도 가능해보임

import java.util.ArrayDeque;

class Solution {
    // cards1, cards2 : 영어단어가 적힌 카드 뭉치(1 ≤ cards1의 길이, cards2의 길이 ≤ 10)
    // 서로 다른 단어만 존재
    // goal: 원하는 단어 배열(2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이)
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 영어단어가 적힌 카드 뭉치를 stack으로 변환
        ArrayDeque<String> stack1 = new ArrayDeque<>();
        ArrayDeque<String> stack2 = new ArrayDeque<>();
        for (int i = cards1.length - 1; i >= 0; i--) {
            stack1.push(cards1[i]);
        }
        for (int i = cards2.length - 1; i >= 0; i--) {
            stack2.push(cards2[i]);
        }
        
        // 만드려는 단어 배열을 queue로 변환
        int n = goal.length;
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.add(goal[i]);
        }
        
        // goal을 순환하며 원하는 단어 배열을 만들 수 있는지 판별
        for (int i = 0; i < goal.length; i++) {
            // 첫번째 카드 뭉치 내에 단어가 존재하는 경우
            if (!stack1.isEmpty() && goal[i].equals(stack1.peek())) {
                // pick한 단어를 stack과 queue에서 제거한다.
                stack1.pop();
                queue.pollFirst();
            }
            // 두번째 카드 뭉치 내에 단어가 존재하는 경우
            else if (!stack2.isEmpty() && goal[i].equals(stack2.peek())) {
                stack2.pop();
                queue.pollFirst();
            }
            // 두 카드 뭉치 내에 단어가 존재하지 않으면
            else {
                return "No";
            }
        }
        
        // 원하는 문자열 만들 수 있으면 "Yes"
        return "Yes";
    }
}
// 한 번에 한 행만 선택 가능, 표의 범위(0행 ~ 마지막 행)를 벗어날 수 없습니다.
// 노드 클래스 구현하여 진행할 것(linkedlist)
import java.util.Stack;
import java.util.Arrays;

class Solution {
    // n: 처음 표의 행 개수(5 ≤ n ≤ 1,000,000)
    // k: 처음에 선택된 행의 위치(0 ≤ k < n)
    // cmd: 수행한 명령어들이 담긴 문자열 배열(1 ≤ cmd의 원소 개수 ≤ 200,000)
    public String solution(int n, int k, String[] cmd) {
        // 삭제된 행의 인덱스를 저장하는 스택
        Stack<Integer> deleted = new Stack<>();

        // 각 행을 기준으로 연산에 따른 위치를 표시하기 위한 배열(링크드리스트)
        // 사이즈를 표의 행 개수보다 2 크게 준 이유는, 테이블의 맨 위와 맨 아래에 가상 공간을 주기 위함
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        // 현재 위치를 나타내는 인덱스 조정
        // 인덱스는 음수를 사용할 수 없으므로, 0행을 1행으로 변경
        k++;

        // 주어진 명령어 배열 처리
        for (String c : cmd) {
            if (c.equals("C")) {    // 삭제
                deleted.push(k);  // 현재 행 삭제 처리

                // 현재 행 윗 행의 down을 현재 행의 down으로
                down[up[k]] = down[k];
                // 현재 행 아래 행의 up을 현재 행의 up으로
                up[down[k]] = up[k];
                
                // 현재 행이 마지막 행이라면 바로 윗 행으로 이동하고, 그렇지 않다면 아래행으로 이동
                k = down[k] > n ? up[k] : down[k];
            } else if (c.equals("Z")) { // 복구(삭제된 행이 존재하는 경우)
                int restore = deleted.pop();  // 삭제했던 행 복구

                // 복구 행 윗행의 down과 아래행의 up을 복구행으로
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {    // 이동(위, 아래)
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                //int x = c.charAt(2) - '0';

                // x칸만큼 이동
                for (int i = 0; i < x; i++) {
                    // 명령어가 'U'인 경우 위로, 'D'인 경우 아래로
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        // 시작 행번호를 1에서 0으로 다시 조정
        for (int i : deleted) {
            answer[i - 1] = 'X';
        }
        
        return new String(answer);
    }
}
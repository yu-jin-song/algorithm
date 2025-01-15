# 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용
# 한 번 사용한 카드는 다시 사용할 수 없다.
# 카드를 사용하지 않고 다음 카드로 넘어갈 수 없다.
# 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없다.
from collections import deque

# cards1, cards2: 문자로 이루어진 배열
# goal: 원하는 단어 배열

def solution(cards1, cards2, goal):
    answer = 'Yes'
    
    queue1 = deque(cards1)
    queue2 = deque(cards2)
    
    for word in goal:
        if queue1 and queue1[0] == word:
            queue1.popleft()
        elif queue2 and queue2[0] == word:
            queue2.popleft()
        else:
            answer = 'No'
            break
            
    return answer
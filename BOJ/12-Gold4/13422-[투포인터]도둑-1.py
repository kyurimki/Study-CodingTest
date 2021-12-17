from collections import deque

t = int(input())  # 테스트케이스 개수
for i in range(t):
    n, m, k = map(int, input().split())  # 집 개수, 훔칠 연속된 집 개수, 방범 장치 작동 최소 돈의 양
    money = list(map(int, input().split()))  # 각 집에서 보관 중인 돈의 양
    
    right = 0
    tmp = 0
    q = deque()
    answer = 0
    for left in range(n):
        while right < n+m-1 and len(q) < m:
            q.append(money[right%n])
            tmp += money[right%n]
            right += 1
        
        if tmp < k:
            answer += 1
        q.popleft()
        tmp -= money[left]
        left += 1
        
        if n == m:
            break
    
    print(answer)
            
t = int(input())  # 테스트케이스 개수
for i in range(t):
    n, m, k = map(int, input().split())  # 집 개수, 훔칠 연속된 집 개수, 방범 장치 작동 최소 돈의 양
    money = list(map(int, input().split()))  # 각 집에서 보관 중인 돈의 양
    
    psum = [0]
    for i in range(1, n+m):
        psum.append(psum[i-1] + money[(i-1)%n])
    
    answer = 0
    if n == m:
        if psum[n] < k:
            answer = 1
    else:
        for i in range(m, n+m):
            if psum[i] - psum[i-m] < k:
                answer += 1
    
    print(answer)
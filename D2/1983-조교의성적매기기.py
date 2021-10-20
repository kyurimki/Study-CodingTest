credit = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']

T = int(input())
for t in range(1, T+1):
    N, K = map(int, input().split())
    score = {}
    for n in range(1, N+1):
        tmp = list(map(int, input().split()))
        score[n] = tmp[0] * 0.35 + tmp[1] * 0.45 + tmp[2] * 0.2
    score = sorted(score.items(), key=lambda x : x[1], reverse=True)

    for i in range(len(score)):
        if score[i][0] == K:
            print("#{} {}".format(t, credit[int(i//(N/10))]))
            break
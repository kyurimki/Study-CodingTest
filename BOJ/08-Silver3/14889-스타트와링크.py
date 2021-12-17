from itertools import combinations

N = int(input())
S = []
for _ in range(N):
    tmp = list(map(int, input().split()))
    S.append(tmp)

sets = list(combinations(range(1, N+1), N//2))

teams = []
for i in range(len(sets)//2):
    s = sets[i]
    l = sets[(len(sets)-1)-i]
    scom = list(combinations(s, 2))
    lcom = list(combinations(l, 2))
    sscore = 0
    lscore = 0
    for i in range(len(scom)):
        sscore += S[scom[i][0]-1][scom[i][1]-1] + S[scom[i][1]-1][scom[i][0]-1]
        lscore += S[lcom[i][0]-1][lcom[i][1]-1] + S[lcom[i][1]-1][lcom[i][0]-1]
    teams.append(abs(sscore-lscore))
print(min(teams))
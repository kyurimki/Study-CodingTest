board = []
for _ in range(19):
    tmp = list(map(int, input().split()))
    board.append(tmp)

dx = [-1, 0, 1, 1]
dy = [1, 1, 0, 1]

def check():
    for i in range(19):
        for j in range(19):
            if board[i][j]:
                for k in range(4):
                    cnt = 1
                    for l in range(1, 5):
                        if -1 < i+dx[k]*l < 19 and -1 < j+dy[k]*l < 19 and board[i+dx[k]*l][j+dy[k]*l] == board[i][j]:
                                cnt += 1
                                if cnt == 5:
                                    if -1 < i+dx[k]*5 < 19 and -1 < j+dy[k]*5 < 19 and board[i+dx[k]*5][j+dy[k]*5] == board[i][j]:
                                        break
                                    if -1 < i-dx[k] < 19 and -1 < j-dy[k] < 19 and board[i-dx[k]][j-dy[k]] == board[i][j]:
                                        break
                                    return board[i][j], (i, j)
                        else:
                                break
                        
    return 0, (0, 0)

a, b = check()
print(a)
if a != 0:
    print(b[0]+1, b[1]+1)
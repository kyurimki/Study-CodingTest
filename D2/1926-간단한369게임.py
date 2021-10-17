T = int(input())

answer = []
for t in range(1, T+1):
    cnt = 0
    cnt += str(t).count('3')
    cnt += str(t).count('6')
    cnt += str(t).count('9')

    if cnt > 0:
        answer.append('-'*cnt)
    else:
        answer.append(str(t))

print(" ".join(answer))
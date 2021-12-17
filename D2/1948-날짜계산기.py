days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

T = int(input())
for t in range(1, T+1):
    m1, d1, m2, d2 = map(int, input().split())
    day = 0
    if m1 == m2:
        day = d2 - d1 + 1
    else:
        for m in range(m1+1, m2):
            day += days[m]
        day += (days[m1] - d1) + d2 + 1
    print("#{} {}".format(t, day))
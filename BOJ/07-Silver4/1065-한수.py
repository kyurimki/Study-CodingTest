def han(n):
    result = 0
    if n < 100:
        result = n
    else:
        result = 99
        for x in range(100, n+1):
            listed = list(map(int, str(x)))

            sub = listed[1] - listed[0]
            flag = True
            for i in range(2, len(listed)):
                if sub != listed[i] - listed[i-1]:
                    flag = False
                    break

            if flag == True:
                result += 1
    return result

print(han(int(input())))
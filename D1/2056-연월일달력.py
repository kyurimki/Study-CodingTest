def check(m, d):
    if m < 1 or m > 13:
        return False
    else:
        if m == 2:
            if 0 < d < 29:
                return True
            else:
                return False
        elif m in [1, 3, 5, 7, 8, 10, 12]:
            if 0 < d < 32:
                return True
            else:
                return False
        else:
            if 0 < d < 31:
                return True
            else:
                return False

T = int(input())
for test_case in range(1, T+1):
    date = input()
    status = check(int(date[4:6]), int(date[6:8]))
    if status:
        print("#{} {}".format(test_case, date[:4]+"/"+date[4:6]+"/"+date[6:]))
    else:
        print("#{} {}".format(test_case, -1))
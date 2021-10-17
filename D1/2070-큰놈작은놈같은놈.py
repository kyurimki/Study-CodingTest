def compare(x, y):
    if x > y:
        return ">"
    elif x == y:
        return "="
    else:
        return "<"

T = int(input())
for test_case in range(1, T + 1):
    x, y = map(int, input().split())
    print("#{} {}".format(test_case, compare(x, y)))
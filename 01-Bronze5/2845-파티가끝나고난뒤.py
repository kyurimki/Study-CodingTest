l, p = map(int, input().split())
ppl = l*p

num = list(map(int, input().split()))
for i in range(len(num)):
    print(num[i]-ppl, end=" ")
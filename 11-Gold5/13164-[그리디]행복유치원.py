n, k = map(int, input().split())
kids = list(map(int, input().split()))

sub = []
for i in range(1, n):
    sub.append(kids[i] - kids[i-1])
sub.sort()
print(sub)

answer = 0
if n == k:
    answer = 0
else:
    for i in range(n-k):
        answer += sub[i]

print(answer)
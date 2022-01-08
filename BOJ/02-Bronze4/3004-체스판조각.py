n = int(input())

answer = 0
if n == 0: answer = 1
elif n % 2 == 0: answer = (n//2+1)**2
else: answer = (n//2+1)*(n//2+2)

print(answer)
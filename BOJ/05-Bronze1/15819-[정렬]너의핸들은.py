n, l = map(int, input().split())
words = []

for _ in range(n):
    words.append(input())

words.sort()

print(words[l-1])
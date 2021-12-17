n = int(input())
words = []
for i in range(n):
    w = input()
    words.append((w, len(w)))

words = list(set(words))

words.sort(key=lambda word:(word[1], word[0]))

for word in words:
    print(word[0])
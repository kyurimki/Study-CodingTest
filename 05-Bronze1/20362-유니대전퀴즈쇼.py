n, s = input().split()
n = int(n)
chats = []
msg = ''

for _ in range(n):
    name, sent = input().split()
    if name == s:
        msg = sent
    chats.append((name, sent))

cnt = 0
for i in range(n):
    if chats[i][0] == s:
        break
    if chats[i][1] == msg:
        cnt += 1

print(cnt)
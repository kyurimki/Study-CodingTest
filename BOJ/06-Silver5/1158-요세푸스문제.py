N, K = map(int, input().split())
ppl = [i for i in range(1, N+1)]

out = []
idx = 0

for _ in range(N):
    idx += (K-1)
    if idx >= len(ppl):
        idx %= len(ppl)

    out.append(str(ppl.pop(idx)))
    
print("<", ", ".join(out), ">", sep='')
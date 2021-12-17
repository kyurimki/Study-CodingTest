n = int(input())  # 수행해야 할 작업

times = [0]  # 작업별 종료 시간
prework = {}  # 작업별 선행작업
for i in range(1, n+1):
    inputs = list(map(int, input().split()))
    times.append(inputs[0])
    if inputs[1] != 0:
        prework[i] = inputs[2:]

# LOGIC: prework에 대해 for문을 돌면서 완료되어야 하는 선행작업을 완료 -> 그 후 작업 완료 -> 시간 저장
# => 가장 큰 값이 제일 늦게 끝난 작업 시간 = 모든 작업을 완료하기 위한 최소 시간
# 문제 조건: 서로 선행 관계가 없는 작업들은 동시에 수행 가능하다. -> 선행 관계가 아니면 작업 시간이 겹쳐도 상관 없음
for i in range(2, n+1):  # 문제 조건: 선행 관계에 있는 작업이 하나도 없는 작업이 반드시 하나 이상 존재한다. (1번 작업이 항상 그러하다)
    if i in prework:
        cur = 0
        for j in prework[i]:
            cur = max(cur, times[j])  # 이전에 완료된 작업인지 아닌지 여부 확인 -> 선행작업이 있다면 그 이후부터 작업 가능
        times[i] += cur

print(max(times))
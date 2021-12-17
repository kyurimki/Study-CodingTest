import sys  # input()은 시간초과 발생

stack = []

def push(stack, x):
    stack.append(x)

def pop(stack):
    if len(stack) > 0:
        print(stack.pop())
    else:
        print(-1)

def size(stack):
    print(len(stack))

def empty(stack):
    if len(stack) == 0:
        print(1)
    else:
        print(0)

def top(stack):
    if len(stack) > 0:
        print(stack[-1])
    else:
        print(-1)

n = int(sys.stdin.readline())

for _ in range(n):
    tmp = sys.stdin.readline().split()
    if tmp[0] == 'push':
        push(stack, int(tmp[1]))
    elif tmp[0] == 'pop':
        pop(stack)
    elif tmp[0] == 'size':
        size(stack)
    elif tmp[0] == 'empty':
        empty(stack)
    else:
        top(stack)
n, t, c, p = map(int, input().split())  # 여름 일수, 자라는 데 걸리는 일수, 심을 수 있는 칸수, 개당 가격
print((n-1) // t * c * p)
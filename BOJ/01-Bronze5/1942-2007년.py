x, y = map(int, input().split())

day = ["MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"]
month = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

days = 0
for i in range(x):
    days += month[i]
days += (y-1)
print(day[days%7])
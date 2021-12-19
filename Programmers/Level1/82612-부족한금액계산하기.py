def solution(price, money, count):
    sum = price * count * (count+1) / 2 - money
    return sum if sum > 0 else 0
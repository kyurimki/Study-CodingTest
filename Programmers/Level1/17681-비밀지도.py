def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        a = str(bin(arr1[i]|arr2[i])[2:])
        a = a.rjust(n, "0")
        a = a.replace("1", "#")
        a = a.replace("0", " ")
        answer.append(a)
    return answer
def solution(phone_book):
    size = len(phone_book)
    phone_book.sort()
    for i in range(size-1):
        if phone_book[i] == phone_book[i+1][0:len(phone_book[i])]:
            return False
    
    return True
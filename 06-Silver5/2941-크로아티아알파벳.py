alphabets = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

string = input()

for c in alphabets:
    string = string.replace(c, '.')

print(len(string))
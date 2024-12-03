def count_occ(num, list):
    count = 0
    for i in list:
        if int(i) == int(num):
            count += 1
    return count

with open('./input.txt', 'r') as file:
    lines = file.readlines()

first = []
second = []
for line in lines:
    firstInt= line.split('   ')[0]
    secondInt = line.split('   ')[1]
    first.append(firstInt)
    second.append(secondInt)

sum=0
for i in first:
    count = count_occ(i, second)
    sum += count*int(i)

print(sum)
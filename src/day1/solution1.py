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
for i in range(len(first)):
    lowestFirst = min(first)
    lowestSecond = min(second)
    dist = abs(int(lowestFirst) - int(lowestSecond))
    sum += dist
    first.remove(lowestFirst)
    second.remove(lowestSecond)

print(sum)
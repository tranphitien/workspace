'''
Created on Nov 30, 2017

@author: EDO
'''

# add two number together
def add(a, b):
    return a+b

# add a input to a fixed number
def addFixedValue(a):
    y = 5
    return a+y

print(add(3,5))

print(addFixedValue(1))

assert(1)

for i in range(0, 100, 2):
    if i < 50:
        print("number is less than 50: ", i)
    else:
        print("number is over than 50: ", i)

a = "abcdefghij"

print(a.upper())
print(len(a))
print(a[4])
print(a[1:4])
print(a[-1])
print(a[-3: -1])
print(a[1] + a[4:7])
print(a.startswith("a"))

if a.startswith("a"):
    print("Oh yeah")
    
# learn about the python list
mylist = ["laptop", "iphone", "iphone", "sony"]

print(mylist)
print(mylist[0])
print(mylist[1:3])
mylist.append("table")
print(mylist)
mylist.remove("table")
print(mylist)
mylist.remove("sony")
mylist = list(set(mylist))
for element in mylist:
    print(element)
    
# processing file
f = open("D:\\05_Work\\Workspace\\PyDev_Learning\\test.csv", "w")

print(f)
for i in range(2,10):
    f.write(str(i) + "\n")

f.close()
print(f)

f = open("D:\\05_Work\\Workspace\\PyDev_Learning\\result.txt", "w")
f2 = open("D:\\05_Work\\Workspace\\PyDev_Learning\\test.csv", "r")

for line in f2:
    f.write(line.rstrip() + "\n")

print(f)

f.close()
f2.close()

s = ""
s2 = ""
f = open("D:\\05_Work\\Workspace\\PyDev_Learning\\result.txt", "r")
f2 = open("D:\\05_Work\\Workspace\\PyDev_Learning\\test.csv", "r")

for line in f:
    s += line

for line in f2:
    s2 += line
    
f.close()
f2.close()

list1 = s.split("\n")
list2 = s2.split("\n")

print(len(list1))
print(len(list2))
print(list1)
print(list2)

difference = list(set(list1).difference(set(list2)))
print(difference)


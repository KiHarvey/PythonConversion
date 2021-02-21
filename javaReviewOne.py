nums = [39, 46, 10, 37, 33, 4, 30, 26, 14, 19, 29, 6, 43, 8, 35, 50,
        13, 25, 17, 48, 28, 3, 41, 34, 36, 38, 49, 16, 45, 2,
        40, 15, 24, 7, 5, 9, 20, 1, 42, 44, 21, 47, 12, 22, 18,
        31, 11, 32, 27, 23]
valid = False
index = -1
x = 0

while valid is not True:
    print("Please enter a number between 1 and 50: ")
    val = input()
    if (int(val) >= 1) and (int(val) <= 50):
        valid = True
        x = int(val)
    else:
        print("Not a valid number")

for i in range(len(nums)):
    if x == nums[i]:
        index = i
        print("The number " + str(val) + " is found on index " + str(index) + " of the array.")
        break

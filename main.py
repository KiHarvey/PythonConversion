# See PyCharm help at https://www.jetbrains.com/help/pycharm/
import sys

rating = [0, 5, 9, 6, 8, 8, 4, 2, 8, 5, 9, 7, 4]
weight = [0, 36, 264, 188, 203, 104, 7, 90, 65, 75, 170, 80, 27]

N = 13  # max number of items
W = 700  # max weight

opt = [[0 for n in range(N + 1)] for w in range(W + 1)]
solution = [[False for n in range(N + 1)] for w in range(W + 1)]

# print(opt)

for n in range(1, N):
    for w in range(1, (W + 1)):
        # don't take item n
        option1 = opt[n - 1][w]
        # take item n
        option2 = -sys.maxsize-1
        if weight[n] <= w:
            option2 = rating[n] + opt[n-1][w-weight[n]]
        # select better of two options
        opt[n][w] = max(option1, option2)
        solution[n][w] = (option2 > option1)
# determine which item to take
take = [False for i in range(N)]
# print(take)
for n, w in zip(range(N-1, -1, -1), range(W)):
    if solution[n][w]:
        take[n] = True
        w = w - weight[n]
    else:
        take[n] = False

print("item\trating\tweight\ttake\n-----------------------------")
for n in range(N):
    print(str(n) + "\t" + str(rating[n]) + "\t" + str(weight[n]) + "\t" + str(take[n]))
print("\n")
totalW = 0
totalR = 0
for i in range(len(take)):
    if take[i]:
        print("item: " + str(i) + " rating: " + str(rating[i]) + " weight: " + str(weight[i]) + "\n")
        totalW += weight[i]
        totalR += rating[i]
print("\nTotal Weight: " + str(totalW) + "\nTotal Rating: " + str(totalR))

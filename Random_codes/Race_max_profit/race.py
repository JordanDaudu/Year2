def race(g, h, f, n):
    # Initialize a 1D list K with dimension n
    K = [0 for _ in range(n)]
    # Check if f is positive numbers and not negative
    if any(i > 0 for i in f):
        for i in range(n):
            if f[i] > 0:
                f[i] = -f[i]
    for i in range(n-1, 0, -1):
        A = max(f[i], (g[i] - h[i]) + K[i])
        K[i-1] = min(A, 0)

    path = [-1 for _ in range(n)]
    if (g[0] - h[0]) + K[0] > f[0]:
        path[0] = 0 # run
        ranInLastCity = True
        total = g[0] - h[0]
    else:
        path[0] = 1 # skip
        ranInLastCity = False
        total = f[0]

    for i in range(1,n):
        if ranInLastCity:
            if (g[i] - h[i]) + K[i] > f[i]:
                path[i] = 0
                total += (g[i] - h[i])
                ranInLastCity = True
            else:
                path[i] = 1
                total += f[i]
                ranInLastCity = False
        else:
            if (g[i] - h[i]) + K[i] > 0:
                path[i] = 0
                total += (g[i] - h[i])
                ranInLastCity = True
            else:
                path[i] = 1
                ranInLastCity = False

    return total, path


g = [10, 10, 15, 3, -15, 30]  # profits for each town
h = [9, 17, 7, 0, 0, 20]  # taxes for each town
f = [-3, -5, -2, -6, -70, -900]  # skipping fees for each town
n = len(g)  # number of towns (0-indexed)

total, path = race(g, h, f, n)
print(total)
print(path)

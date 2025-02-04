import numpy as np
from colors import bcolors

#  swapping between row i to row j in the matrix
def swap_row(mat, i, j):
    N = len(mat)
    for k in range(N + 1):
        temp = mat[i][k]
        mat[i][k] = mat[j][k]
        mat[j][k] = temp

def gaussianElimination(A, b):
    N = len(A)

    # Combine A and b into an augmented matrix
    mat = [row + [b_val] for row, b_val in zip(A, b)]

    singular_flag = forward_substitution(mat)

    if singular_flag != -1:
        if mat[singular_flag][N]:
            return "Singular Matrix (Inconsistent System)"
        else:
            return "Singular Matrix (May have infinitely many solutions)"

    # If matrix is non-singular: get solution to system using backward substitution
    return backward_substitution(mat)


def forward_substitution(mat):
    N = len(mat)
    for k in range(N):
        # Partial Pivoting: Find the pivot row with the largest absolute value in the current column
        pivot_row = k
        v_max = abs(mat[pivot_row][k])
        for i in range(k + 1, N):
            if abs(mat[i][k]) > v_max:
                v_max = abs(mat[i][k])
                pivot_row = i

        # If a principal diagonal element is zero, matrix is singular
        if not mat[pivot_row][k]:
            return k  # Matrix is singular

        # Swap the current row with the pivot row
        if pivot_row != k:
            swap_row(mat, k, pivot_row)

        for i in range(k + 1, N):
            # Compute the multiplier
            m = mat[i][k] / mat[k][k]

            # Subtract the multiple of kth row element
            for j in range(k, N + 1):
                mat[i][j] -= mat[k][j] * m

            # Fill lower triangular matrix with zeros
            mat[i][k] = 0

    return -1


# Function to calculate the values of the unknowns
def backward_substitution(mat):
    N = len(mat)
    x = np.zeros(N)  # An array to store the solution

    # Start calculating from last equation up to the first
    for i in range(N - 1, -1, -1):
        x[i] = mat[i][N]

        # Initialize j to i+1 since matrix is upper triangular
        for j in range(i + 1, N):
            x[i] -= mat[i][j] * x[j]

        x[i] = x[i] / mat[i][i]

    return x


if __name__ == '__main__':

    matrixA = [[1, 0.5, 1/3],
               [0.5, 1/3, 0.25],
               [1/3, 0.25, 0.20]]

    vectorB = [1, 0, 0]

    result = gaussianElimination(matrixA, vectorB)
    if isinstance(result, str):
        print(result)
    else:
        print(bcolors.OKBLUE, "\nSolution for the system:")
        for x in result:
            print(bcolors.OKGREEN, "{:.6f}".format(x), bcolors.ENDC)

import numpy as np
import sympy
from colors import bcolors


def romberg_integration(func, a, b, n):
    """
    Romberg Integration

    Parameters:
    func (function): The function to be integrated.
    a (float): The lower limit of integration.
    b (float): The upper limit of integration.
    n (int): The number of iterations (higher value leads to better accuracy).

    Returns:
    float: The approximate definite integral of the function over [a, b].
    """
    h = b - a
    R = np.zeros((n, n), dtype=float)

    R[0, 0] = 0.5 * h * (func(a) + func(b))

    for i in range(1, n):
        h /= 2
        sum_term = 0

        for k in range(1, 2 ** i, 2):
            sum_term += func(a + k * h)

        R[i, 0] = 0.5 * R[i - 1, 0] + h * sum_term

        for j in range(1, i + 1):
            R[i, j] = R[i, j - 1] + (R[i, j - 1] - R[i - 1, j - 1]) / ((4 ** j) - 1)

    return R[n - 1, n - 1]


if __name__ == '__main__':

    a = 0
    b = 1
    n = 16
    f = lambda x: (sympy.sin(2*x**3 + 5*x**2 - 6)) / (2*sympy.exp(-2*x))
    integral = romberg_integration(f, a, b, n)

    print(bcolors.GOLD ,f"\nDivision into n={n} sections ", bcolors.ENDC)
    print(bcolors.OKBLUE, f"\nApproximate integral in range [{a},{b}] is {integral}", bcolors.ENDC)


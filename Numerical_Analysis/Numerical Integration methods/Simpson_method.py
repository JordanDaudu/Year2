import numpy as np
from colors import bcolors

def simpsons_rule(f, a, b, n):
    """
    Simpson's Rule for Numerical Integration

    Parameters:
    f (function): The function to be integrated.
    a (float): The lower limit of integration.
    b (float): The upper limit of integration.
    n (int): The number of subintervals (must be even).

    Returns:
    float: The approximate definite integral of the function over [a, b].
    """
    if n % 2 != 0:
        raise ValueError("Number of subintervals (n) must be even for Simpson's Rule.")

    h = (b - a) / n

    integral = f(a) + f(b)  # Initialize with endpoints

    for i in range(1, n):
        x_i = a + i * h
        if i % 2 == 0:
            integral += 2 * f(x_i)
        else:
            integral += 4 * f(x_i)

    integral *= h / 3

    return integral


if __name__ == '__main__':
    f = lambda x: (np.sin(2*x**3 + 5*x**2 - 6)) / (2*np.exp(-2*x))
    n = 16
    a=0
    b=1

    print(bcolors.GOLD ,f"\nDivision into n = {n} sections ", bcolors.ENDC)
    integral = simpsons_rule(f, a, b, n)
    print(bcolors.OKBLUE, f"\nNumerical Integration of definite integral in range [{a},{b}] is {integral}", bcolors.ENDC)


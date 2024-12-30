class bcolors:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKCYAN = '\033[96m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'

def newton_raphson(f, df, p0, TOL, N=50):
    """
    Newton-Rapson method for solving f(x) = 0
    :param f: function
    :param df: derivative of function
    :param p0: initial guess
    :param TOL: tolerance
    :param N: maximum number of iterations
    :return: approximate root
    """
    print("{:<10} {:<15} {:<15} ".format("Iteration", "po", "p1"))
    for i in range(N):
        if df(p0) == 0:
            print( "Derivative is zero at p0, method cannot continue.")
            return

        p = p0 - f(p0) / df(p0)

        if abs(p - p0) < TOL:
            return p  # Procedure completed successfully
        print("{:<10} {:<15.9f} {:<15.9f} ".format(i, p0, p))
        p0 = p
    return p


if __name__ == '__main__':
    f = lambda x: x**3 - 3*x**2
    df = lambda x: 3*x**2 - 6*x
    p0 = -5
    TOL = 1e-6
    N = 100
    roots = newton_raphson(f, df,p0,TOL,N)
    print(bcolors.OKBLUE,"\nThe equation f(x) has an approximate root at x = {:<15.9f} ".format(roots),bcolors.ENDC,)

import sympy
from colors import bcolors
TOL = 0.0001


def generate_intervals(start, end, step=0.1, epsilon=1e-10):
    """
    Generate a list of intervals with a specified step size, ensuring no duplicate numbers.

    Parameters:
    start (float): The starting value of the range.
    end (float): The ending value of the range.
    step (float): The size of each interval. Default is 0.1.
    epsilon (float): A small value added to ensure no duplicate numbers. Default is 1e-10.

    Returns:
    list of tuples: A list of intervals as (start, end) tuples.
    """
    intervals = []
    current = start
    while current < end:
        next_val = current + step
        if next_val > end:
            next_val = end
        intervals.append((current, next_val))
        current = next_val + epsilon  # Add a small offset to avoid duplication
    return intervals


def merge_close_roots(roots, tolerance=TOL*5):
    """
    Merge close roots into a single root based on a given tolerance.

    Parameters:
    roots (list of float): A list of detected roots.
    tolerance (float): The maximum distance between roots to consider them the same.

    Returns:
    list of float: A list of unique roots.
    """
    if not roots:
        return []
    if tolerance > 0.01:
        print(bcolors.WARNING ,"\nTolerance for merging function is too high, you may merge close roots that are in fact 2 separate roots.")
    roots.sort()
    print(bcolors.GRAY, "\nNote: roots that are close to 0 by 1e-8 will be rounded to 0", bcolors.ENDC)
    merged_roots = [roots[0] if abs(roots[0]) > 1e-8 else 0]
    for root in roots[1:]:
        if abs(root - merged_roots[-1]) > tolerance:
            merged_roots.append(root if abs(root) > 1e-8 else 0)  # Adjust root close to zero
    return merged_roots



def min_steps_bisection_method(a, b, err):
    """
    Calculate the minimum number of iterations required to reach the desired accuracy
    using the bisection method.

    Parameters:
    a (float): Start value.
    b (float): End value.
    err (float): Tolerable error.

    Returns:
    int: The minimum number of iterations required.
    """
    def exp_approx(y):
        """
        Calculate an approximate value of e^y using a Taylor series.
        """
        result, term, n = 1, 1, 1
        while abs(term) > 1e-10:
            term *= y / n
            result += term
            n += 1
        return result

    def ln(x):
        """
        Calculate the natural logarithm of x using Newton's method.
        Valid for x > 0.

        Parameters:
        x (float): The input value.

        Returns:
        float: The natural logarithm of x.
        """
        if x <= 0:
            raise ValueError("ln(x) is undefined for non-positive values.")

        y = x - 1  # Initial guess for ln(x)
        for _ in range(100):  # Limit iterations to ensure convergence
            y -= (exp_approx(y) - x) / exp_approx(y)
            if abs(exp_approx(y) - x) < 1e-10:
                break
        return y

    # Calculate k using the formula k > -(ln((b - a) / err) / ln(2)) - 1
    k_plus_1 = ln(err / (b - a)) / ln(0.5)
    k = k_plus_1 - 1  # Adjust for k+1
    return int(k) + 1 if k % 1 != 0 else int(k)



def bisection_method(f, a, b, TOL=0.0001, verbose=True):
    """
    Perform the bisection method to approximate the root of a continuous function.

    Parameters:
    f (function): Continuous function on the interval [a, b], where f(a) and f(b) have opposite signs.
    a (float): Start value of the interval.
    b (float): End value of the interval.
    tol (float, optional): Tolerable error. Defaults to 0.0001.
    verbose (bool, optional): Whether to print iteration details. Defaults to True.

    Returns:
    tuple: (root, iterations, converged)
        root (float): The approximate root of the function f.
        iterations (int): The number of iterations performed.
        converged (bool): Whether the method converged within the tolerance.
    """
    if a >= b:
        raise ValueError("Invalid interval: 'a' must be less than 'b'")
    if TOL <= 0:
        raise ValueError("Tolerance must be positive")
    if f(a) * f(b) >= 0:
        return None, None, False
    print(bcolors.MAGENTA, "\nPotential root in interval:", "{:.3f}".format(a), "{:.3f}".format(b), bcolors.ENDC)
    if TOL > 0.01:
        print(bcolors.WARNING ,"Tolerance is too high, you may receive faulty results.")

    c, k = 0, 0
    min_steps = min_steps_bisection_method(a, b, TOL)  # Calculate the min steps needed
    print(bcolors.OKCYAN, "With the error estimation formula we got the minimum number of iterations required to reach the desired accuracy is", min_steps, bcolors.ENDC)
    if verbose:
        print("{:<10} {:<15} {:<15} {:<15} {:<15} {:<15} {:<15}".format("Iteration", "a", "b", "f(a)", "f(b)", "c", "f(c)"))

    while abs(b - a) > TOL and k < min_steps:
        c = a + (b - a) / 2  # Calculate the midpoint
        fc = f(c)

        if verbose:
            print("{:<10} {:<15.6f} {:<15.6f} {:<15.6f} {:<15.6f} {:<15.6f} {:<15.6f}".format(k, a, b, f(a), f(b), c, fc))

        if abs(fc) < TOL:  # Check if f(c) is close enough to 0
            return c, k + 1, True

        if fc * f(a) < 0:  # Root lies in [a, c]
            b = c
        else:  # Root lies in [c, b]
            a = c

        k += 1

    # Return the root, iterations, and convergence status
    return c, k, True



def newton_raphson(f, df, TOL=0.0001, N=100, start_point=None, end_point=None, verbose=True):
    """
    Newton-Raphson method for solving f(x) = 0.

    Parameters:
    f (function): Function for which the root is to be approximated.
    df (function): Derivative of the function.
    p0 (float): Initial guess.
    TOL (float, optional): Tolerance. Defaults to 0.0001.
    N (int, optional): Maximum number of iterations. Defaults to 100.
    verbose (bool, optional): Whether to print iteration details. Defaults to True.
    start_point (float, optional): Start point of the interval for checking root existence.
    end_point (float, optional): End point of the interval for checking root existence.

    Returns:
    tuple: (root, iterations, converged)
        root (float): The approximate root of the function f.
        iterations (int): The number of iterations performed.
        converged (bool): Whether the method converged within the tolerance.
    """
    if start_point >= end_point:
        raise ValueError("Invalid interval: 'a' must be less than 'b'")
    if TOL <= 0:
        raise ValueError("Tolerance must be positive")

    if TOL > 0.01:
        print(bcolors.WARNING ,"Tolerance is too high, you may receive faulty results.")
    if abs(f(start_point)) < TOL:
        print(bcolors.MAGENTA, "\nPotential root in interval:", "{:.3f}".format(a), "{:.3f}".format(b), bcolors.ENDC)
        print("\n{:.3f}".format(start_point), " was the root of the function, no need for iterations.")
        return start_point, 0, True
    if abs(f(end_point)) < TOL:
        print(bcolors.MAGENTA, "\nPotential root in interval:", "{:.3f}".format(a), "{:.3f}".format(b), bcolors.ENDC)
        print(f"\n{end_point} was the root of the function, no need for iterations.")
        return end_point, 0, True

    if f(start_point) * f(end_point) >= 0:
        return None, None, False

    print(bcolors.MAGENTA, "\nPotential root in interval:", "{:.3f}".format(a), "{:.3f}".format(b), bcolors.ENDC)
    # getting initial guess
    p0 = (start_point + end_point) / 2 if start_point + end_point != 0 else TOL

    if verbose:
        print("{:<10} {:<15} {:<15} {:<15} {:<15}".format("Iteration", "p0", "f(p0)", "df(p0)", "p"))

    for i in range(N):
        f_p0 = f(p0)
        df_p0 = df(p0)

        if df_p0 == 0:
            raise ValueError(f"Derivative is zero at iteration {i}, method cannot continue.")

        p = p0 - f_p0 / df_p0

        if verbose:
            print("{:<10} {:<15.9f} {:<15.9f} {:<15.9f} {:<15.9f}".format(i, p0, f_p0, df_p0, p))

        if abs(p - p0) < TOL:  # Convergence criteria
            return p, i + 1, True

        if p < start_point or p > end_point:
              print(bcolors.WARNING, "Current root is out of bound of the interval.", bcolors.ENDC)
              return None, None, False

        p0 = p

    return p, N, False




def secant_method(f, x0, x1, TOL=0.0001, N=100, verbose=True):
    """
    Secant method for solving f(x) = 0.

    Parameters:
    f (function): Function for which the root is to be approximated.
    x0 (float): First initial guess.
    x1 (float): Second initial guess.
    TOL (float): Tolerance for stopping criteria.
    N (int): Maximum number of iterations. Defaults to 100.
    verbose (bool): Whether to print iteration details. Defaults to True.

    Returns:
    tuple: (root, iterations, converged)
        root (float): The approximate root of the function f.
        iterations (int): The number of iterations performed.
        converged (bool): Whether the method converged within the tolerance.
    """
    if x0 >= x1:
        raise ValueError("Invalid interval: 'a' must be less than 'b'")
    if TOL <= 0:
        raise ValueError("Tolerance must be positive")

    if TOL > 0.01:
        print(bcolors.WARNING ,"Tolerance is too high, you may receive faulty results.")
    if abs(f(x0)) < TOL:
        print(bcolors.MAGENTA, "\nPotential root in interval:", "{:.3f}".format(x0), "{:.3f}".format(x1), bcolors.ENDC)
        print("\n{:.3f}".format(x0), " was the root of the function, no need for iterations.")
        return x0, 0, True
    if abs(f(x1)) < TOL:
        print(bcolors.MAGENTA, "\nPotential root in interval:", "{:.3f}".format(x0), "{:.3f}".format(x1), bcolors.ENDC)
        print("\n{:.3f}".format(x1), " was the root of the function, no need for iterations.")
        return x1, 0, True
    start = x0
    end = x1

    if f(start) * f(end) >= 0:
        return None, None, False

    print(bcolors.MAGENTA, "\nPotential root in interval:", "{:.3f}".format(x0), "{:.3f}".format(x1), bcolors.ENDC)
    if verbose:
        print("{:<10} {:<15} {:<15} {:<15}".format("Iteration", "x0", "x1", "p"))

    for i in range(N):
        # Check if denominator is near zero (avoid division by zero)
        if f(x1) - f(x0) == 0:
            print("Denominator is zero, method cannot continue.")
            return None, i, False

        # Calculate new approximation using secant method formula
        p = x0 - f(x0) * ((x1 - x0) / (f(x1) - f(x0)))

        # Print iteration details if verbose is True
        if verbose:
            print("{:<10} {:<15.6f} {:<15.6f} {:<15.6f}".format(i, x0, x1, p))

        # Check if the method has converged
        if abs(p - x1) < TOL:
            return p, i + 1, True  # Method completed successfully

        if p < start or p > end:
            print(bcolors.WARNING, "Current root is out of bound of the interval.", bcolors.ENDC)
            return None, None, False

        # Update x0 and x1 for the next iteration
        x0 = x1
        x1 = p

    # If method doesn't converge within N iterations
    return p, N, False



# Function to get a sympy polynomial from the user
# Please input the polynomial in the function below
def initializeSympyPolynomialData():
    """
    gets a polynomial as input, the polynomial syntax should be sympy polynomial syntax,
    returns the necessary information for the rest of the work with the polynomial.

    @return: tuple: (sympy polynomial, derivative, polynomial lambdify, derivative lambdify, polynomial degree)
    """
    x = sympy.symbols('x')
    # get polynomial from user
    polynomial = sympy.cos(x**2 + 5*x + 6) / 2*sympy.exp(-x)
    #print("Polynomial", polynomial)
    derivative = sympy.diff(polynomial, x)
    #print("derivative: ",derivative)
    f = sympy.utilities.lambdify(x, polynomial, "math")  # Use "math" for mathematical functions
    #print("f: ",f)
    fTag = sympy.utilities.lambdify(x, derivative, "math")  # Use "math" for derivative
    #print("ftag: ",fTag)
    polynomialDegree = int(sympy.degree(polynomial))
    return polynomial, derivative, f, fTag, polynomialDegree


# Please input the polynomial you want to use in the function initializeSympyPolynomialData()
polynomial, derivative, f, fTag, polynomialDegree = initializeSympyPolynomialData()



# Main code
# Please input the polynomial you want to use in the function initializeSympyPolynomialData()
# Input the starting and ending point of the interval you want to search for roots and the step size
starting_point, ending_point = -1.5, 2
search_range = generate_intervals(starting_point, ending_point, step=0.1)
roots = []
while True:
    print("Please choose the method you want to use:")
    print("1. Bisection Method")
    print("2. Newton-Raphson Method")
    print("3. Secant Method")
    try:
        choice = int(input("Enter your choice: "))
        if choice in [1, 2, 3]:
            break
        else:
            print(bcolors.WARNING,"Invalid choice. Please enter 1, 2, or 3.", bcolors.ENDC)
    except ValueError:
        print(bcolors.WARNING,"Invalid input. Please enter a number (1, 2, or 3).", bcolors.ENDC)

print("================================================================================")

print(bcolors.ORANGE, f"Searching for roots in the interval [{starting_point}, {ending_point}] in steps of 0.1:", bcolors.ENDC)
print(bcolors.GOLD ,"Whenever a potential root is found, the method will be applied to the smaller interval to check for convergence.\n", bcolors.ENDC)
if choice == 1:
    print(bcolors.OKBLUE, "You have chosen the Bisection Method.", bcolors.ENDC)
    print(bcolors.HEADER, "Trying f to converge first:", bcolors.ENDC)
    for i in range(len(search_range)):
        try:
            a, b = search_range[i]
            root, iterations, converged = bisection_method(f, a, b)
            if root is not None:
                if converged:
                    roots.append(root)
                    print(bcolors.OKBLUE, f"\nThe equation f(x) has an approximate root at x = {root}",
                          bcolors.ENDC)
                    print(bcolors.OKGREEN, f"\nf(x) root = {root}", bcolors.ENDC)
                else:
                    print(bcolors.WARNING, f"\nThe method did not converge after {iterations} iterations.",
                          bcolors.ENDC)
        except ValueError as e:
            print(bcolors.FAIL, f"ValueError: {e}", bcolors.ENDC)
        except Exception as e:
            print(bcolors.FAIL, f"An error occurred: {e}", bcolors.ENDC)
    if not roots:
        print(bcolors.WARNING, "No roots found for f(x).", bcolors.ENDC)

    print(bcolors.HEADER, "\nTrying fTag to converge secondly:", bcolors.ENDC)
    for i in range(len(search_range)):
        try:
            a, b = search_range[i]
            root, iterations, converged = bisection_method(fTag, a, b)
            if root is not None:
                if converged:
                    if abs(f(root)) <= abs(TOL):
                        roots.append(root)
                        print(bcolors.OKBLUE, f"\nThe equation f(x) has an approximate root at x = {root}",
                              bcolors.ENDC)
                        print(bcolors.OKGREEN, f"\nf(x) root = {root}", bcolors.ENDC)
                    else:
                        print(bcolors.WARNING,
                              f"\nThe method did converge for fTag after {iterations} iterations, but the given root isn't actually a root for f.",
                              bcolors.ENDC)
                else:
                    print(bcolors.WARNING, f"\nThe method did not converge after {iterations} iterations.",
                          bcolors.ENDC)
        except ValueError as e:
            print(bcolors.FAIL, f"ValueError: {e}", bcolors.ENDC)
        except Exception as e:
            print(bcolors.FAIL, f"An error occurred: {e}", bcolors.ENDC)
    roots = merge_close_roots(roots)
    if not roots:
        print(bcolors.FAIL, "No roots found for f(x) or fTag(x).", bcolors.ENDC)
    else:
        print(bcolors.OKGREEN, bcolors.BOLD, f"\nRoots found after merging close roots: {roots}", bcolors.ENDC)

elif choice == 2:
    print(bcolors.OKBLUE, "You have chosen the Newton-Raphson Method.", bcolors.ENDC)
    for i in range(len(search_range)):
        try:
            a, b = search_range[i]
            root, iterations, converged = newton_raphson(f, fTag, start_point=a, end_point=b)
            if root is not None:
                if converged:
                    roots.append(root)
                    print(bcolors.OKBLUE, f"\nThe equation f(x) has an approximate root at x = {root}",
                          bcolors.ENDC)
                else:
                    print(bcolors.WARNING, f"\nThe method did not converge after {iterations} iterations.",
                          bcolors.ENDC)
        except ValueError as e:
            print(bcolors.FAIL, f"ValueError: {e}", bcolors.ENDC)
        except Exception as e:
            print(bcolors.FAIL, f"An error occurred: {e}", bcolors.ENDC)

    roots = merge_close_roots(roots)
    if not roots:
        print(bcolors.FAIL, "No roots found for f(x).", bcolors.ENDC)
    else:
        print(bcolors.OKGREEN, bcolors.BOLD, f"\nRoots found after merging close roots: {roots}", bcolors.ENDC)

elif choice == 3:
    print(bcolors.OKBLUE, "You have chosen the Secant Method.", bcolors.ENDC)
    for i in range(len(search_range)):
        try:
            x0, x1 = search_range[i]
            root, iterations, converged = secant_method(f, x0, x1)
            if root is not None:
                if converged:
                    roots.append(root)
                    print(bcolors.OKBLUE, f"\nThe equation f(x) has an approximate root at x = {root}",
                          bcolors.ENDC)
                else:
                    print(bcolors.WARNING, f"\nThe method did not converge after {iterations} iterations.",
                          bcolors.ENDC)
        except ValueError as e:
            print(bcolors.FAIL, f"ValueError: {e}", bcolors.ENDC)
        except Exception as e:
            print(bcolors.FAIL, f"An error occurred: {e}", bcolors.ENDC)

    roots = merge_close_roots(roots)
    if not roots:
        print(bcolors.FAIL, "No roots found for f(x).", bcolors.ENDC)
    else:
        print(bcolors.OKGREEN, bcolors.BOLD, f"\nRoots found after merging close roots: {roots}", bcolors.ENDC)
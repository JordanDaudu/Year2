def binary_search(sorted_list, value, start, end):
    """
    This function implements the binary search algorithm.
    :param sorted_list: list of sorted elements
    :param value:  element to be searched
    :param start:  start index of the list
    :param end:  end index of the list
    :return:  index of the element, -1 if not found
    """
    if start > end:
        return -1

    mid = (start + end) // 2
    if sorted_list[mid] == value:
        return mid
    elif sorted_list[mid] > value:
        return binary_search(sorted_list, value, start, mid - 1)
    else:
        return binary_search(sorted_list, value, mid + 1, end)

def generate_combinations(list, k):
    """
    This function generates all possible combinations of k elements from the list.
    :param list: list of elements
    :param k: number of elements in the combination
    :return: list of combinations
    """
    if k == 0:
        return [[]]
    if k == len(list):
        return [list]
    if len(list) == 0:
        return []

    head = list[0]
    tail = list[1:]

    with_head = [[head] + x for x in generate_combinations(tail, k - 1)]
    without_head = generate_combinations(tail, k)

    return with_head + without_head

def apply_twice(func, x):
    """
    This function applies the given function twice on the given element.
    :param func:  function to be applied
    :param x:  element on which function is to be applied
    :return:  result of the function
    """
    return func(func(x))

def create_multiplier(n):
    """
    This function creates a multiplier function which multiplies the given number with n.
    :param n: number with which the number is to be multiplied
    :return: multiplier function
    """
    def multiplier(x):
        return x * n
    return multiplier

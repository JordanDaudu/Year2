# שמות המגישים
# Jordan Dudu - 323909366
# Joe Ben Simon - 340854371
from functools import reduce

# חלק א
def top_student(grades): # Question 1
    """
    This function identifies students who scored above 90 in at least three courses.

    Parameters:
    grades (list): A list of tuples, where each tuple contains (student_name, course, grade).

    Returns:
    list: A list of student names who scored above 90 in three or more courses.
    """
    # Filter the grades list to include only records where the grade is 90 or higher.
    grades_higher_from_90 = filter(lambda x: x[2] >= 90, grades)

    # Map the filtered list to a list of tuples where the course name is the key and the value is 1.
    grades_mapping = map(lambda x: (x[0], 1), grades_higher_from_90)

    # Reduce the list of tuples to a dictionary where the key is the course name and the value is the number of times the student scored above 90.
    grade_counts = reduce(lambda acc, curr: {**acc, curr[0]: acc.get(curr[0], 0) + curr[1]}, grades_mapping, {})

    # Filter the dictionary to include only students who scored above 90 in three or more courses.
    student_with_3_grades_higher_than_90 = filter(lambda student: student[1] >= 3, grade_counts.items())

    # Extract the names of students from the filtered records and convert them into a list.
    top_students = list(map(lambda student: student[0], student_with_3_grades_higher_than_90))

    # Return the final list of top students.
    return top_students


def is_prime_square(numbers): # Question 2
    """
    This function calculates the squares of all prime numbers in the input list.

    Parameters:
    numbers (list): A list of integers, assume only positive numbers.

    Returns:
    list: A list containing the squares of all prime numbers in the input list.
    """
    def square(x):
        """
        Calculate the square of a number.

        Parameters:
        x (int): The number to square.

        Returns:
        int: The square of the number.
        """
        return x ** 2

    def is_prime(n):
        """
        Check if a number is a prime number.

        Parameters:
        n (int): The number to check.

        Returns:
        bool: True if the number is prime, False otherwise.
        """
        if n <= 1:
            return False
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False
        return True

    # Filter the list to include only prime numbers
    prime_numbers_square = filter(is_prime, numbers)
    # Apply the square function only to the filtered prime numbers
    prime_numbers_square = map(square, prime_numbers_square)
    # Convert the result to a list and return.
    return list(prime_numbers_square)


def most_expensive_in_category(products): # Question 3
    """
    This function finds the most expensive product in each category.

    Parameters:
    products (list): A list of tuples, where each tuple contains (product_name, category, price).

    Returns:
    list: A list of tuples, each containing the product name and price of the most expensive product in each category.
    """
    # Step 1: Extract unique categories from the product list
    categories = list(set(map(lambda x: x[1], products)))

    # Step 2: Find the most expensive product for each category:
    # - Iterates over each unique category in the list
    # - Filters the products list to include only items that belong to the current category
    # - Finds the product with the highest price (item[2]) in the filtered list for the current category
    # - Converts the resulting map object into a list, containing the most expensive product for each category
    result = list(map(lambda category: max(filter(lambda x: x[1] == category, products),key=lambda item: item[2]),categories))

    # Step 3: Format the output as (product_name, price)
    return list(map(lambda product: (product[0], product[2]), result))


def multiply_numbers_that_divide_in_3_and_5(numbers): # Question 4
    """
    This function calculates the product of all numbers in the input list that are divisible by 3 or 5.

    Parameters:
    numbers (list): A list of integers.

    Returns:
    int: The product of all numbers divisible by 3 or 5.
    """
    def multiply_numbers(numbers_to_filter_and_multiply):
        """
        Filters numbers divisible by 3 or 5 and calculates their product.

        Parameters:
        numbers_to_filter_and_multiply (list): A list of integers to filter and multiply.

        Returns:
        int: The product of the filtered numbers.
        """
        # Filter numbers divisible by 3 or 5.
        divisible = filter(lambda x: x % 3 == 0 or x % 5 == 0, numbers_to_filter_and_multiply)
        # Calculate the product of the filtered numbers.
        multiply = reduce(lambda x, y: x * y, divisible)
        # Return the final product.
        return multiply
    # Call the inner function to process the input list and return the result.
    return multiply_numbers(numbers)


def extract_long_words_without_punctuation_marks(text): # Question 5
    """
    This function extracts all words longer than 7 characters from a given string after removing punctuation marks.

    Parameters:
    text (str): The input string containing words and punctuation.

    Returns:
    list: A list of words longer than 7 characters, without punctuation.
    """
    def extract_long_words(text_to_remove_punctuation_marks):
        """
        Removes punctuation from the input text and extracts long words.

        Parameters:
        text_to_remove_punctuation_marks (str): The input string to process.

        Returns:
        list: A list of words longer than 7 characters, without punctuation.
        """
        # Define a string containing punctuation marks to remove.
        punctuation = '''!()-[]{};:'",<>./?@#$%^&*_~'''
        def remove_punctuation(word):
            """
            Removes punctuation from a word.

            Parameters:
            word (str): The word to process.

            Returns:
            str: The word without punctuation.
            """
            # Remove all punctuation characters from the word.
            return ''.join(map(lambda char: '' if char in punctuation else char, word))
        # Split the text into words.
        words = text_to_remove_punctuation_marks.split()
        # Remove punctuation from each word.
        words_no_punctuation = map(remove_punctuation, words)
        # Filter words longer than 7 characters.
        long_words = filter(lambda x: len(x) > 7, words_no_punctuation)
        # Return the filtered words as a list.
        return list(long_words)
    # Process the input text and return the result
    return extract_long_words(text)



# חלק ב
def make_currency(amount, symbol): # Question 1
    """
    This function creates a currency object using a dispatch function and message passing.

    Parameters:
    amount (float): The initial amount of the currency.
    symbol (str): The symbol representing the currency.

    Returns:
    function: A dispatch function to handle currency-related operations.
    """
    def get_value(param):
        """Retrieves the value of the amount or symbol based on the parameter"""
        if param == 'amount':
            return amount
        elif param == 'symbol':
            return symbol
    def set_value(param, value):
        """Sets the value of the amount or symbol based on the parameter"""
        nonlocal amount, symbol
        if param == 'amount':
            amount = value
        elif param == 'symbol':
            symbol = value
    def convert(func, convert_symbol):
        """Converts the currency amount using a given function and symbol"""
        nonlocal amount, symbol
        amount = func(amount)
        symbol = convert_symbol
        print("Conversion was successful")
    def dispatch(msg):
        """Dispatch function to handle different messages"""
        nonlocal amount, symbol
        if msg == 'get_value':
            return get_value
        elif msg == 'set_value':
            return set_value
        elif msg == 'str':
            return f'{symbol}{amount}'
        elif msg == 'convert':
            return convert

    return dispatch


def make_mutable_rlist(copy_from=None): # Question 2
    """
    Return a functional implementation of a mutable recursive list.
    Parameters:
    copy_from (dict): A dictionary containing the attributes of the list to copy.
    Returns:
    dict: A dictionary containing the attributes and methods of the mutable recursive list.
    """
    attributes = {}
    contents = None

    def make_rlist(first, rest):
        """Make a recursive list from its first element and the rest."""
        return first, rest

    def first(s):
        """Return the first element of a recursive list s."""
        return s[0]

    def rest(s):
        """Return the rest of the elements of a recursive list s."""
        return s[1]

    def len_rlist(s):
        """Return the length of recursive list s."""
        length = 0
        while s is not None:
            s, length = rest(s), length + 1
        return length

    def getitem_rlist(s, i):
        """Return the element at index i of recursive list s."""
        while i > 0:
            s, i = rest(s), i - 1
        return first(s)

    def length():
        return len_rlist(contents)

    def get_item(ind):
        return getitem_rlist(contents, ind)

    def push_first(value):
        nonlocal contents
        contents = make_rlist(value, contents)

    def pop_first():
        nonlocal contents
        f = first(contents)
        contents = rest(contents)
        return f

    def slice_rlist(s, start, end):
        """Return a slice of the recursive list."""
        new_list = make_mutable_rlist()
        index = 0
        while s is not None and index < end:
            if index >= start:
                new_list['push_first'](first(s))
            s, index = rest(s), index + 1
        return reverse_rlist(new_list)

    def reverse_rlist(rlist):
        """Reverse the contents of the list for correct order."""
        result = make_mutable_rlist()
        while rlist['length']() > 0:
            result['push_first'](rlist['pop_first']())
        return result

    def str():
        nonlocal contents
        tup = contents
        result = []
        while tup is not None:
            result.append(tup[0])
            tup = tup[1]
        print(result)

    def extend(other):
        elements = []
        for i in range(other['length']()):
            elements.append(other['get_item'](i))

        for element in reversed(elements):
            push_first(element)

    def slice(start, end):
        return slice_rlist(contents, start, end)

    def get_iterator():
        index = 0

        def has_next():
            return index < length()

        def next_item():
            nonlocal index
            item = get_item(index)
            index += 1
            return item

        return {'hasNext': has_next, 'next': next_item}

    if copy_from:
        elements = []
        for i in range(copy_from['length']()):
            elements.append(copy_from['get_item'](i))

        for element in reversed(elements):  # Reverse the order to maintain the correct order
            push_first(element)

    def dispatch_dict():
        return {
            'length': length,
            'get_item': get_item,
            'push_first': push_first,
            'pop_first': pop_first,
            'str': str,
            'extend': extend,
            'slice': slice,
            'get_iterator': get_iterator
        }
    return dispatch_dict()

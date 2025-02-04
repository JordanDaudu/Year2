from functools import reduce
from operator import mul, add, mod, pow

# Question 1
def make_class(attributes, base_class=None):
    """
    Creates a class (as a dispatch dictionary) with specified attributes and optional inheritance.

    :param attributes: A dictionary of static data members and methods of the class.
    :param base_class: A list of base classes (dispatch dictionaries) for inheritance.
    :return: A class (dispatch dictionary) with 'get', 'set', and 'new' functionalities.
    """
    def get_value(name):
        """
        Retrieve the value of an attribute from the class or its base classes.

        :param name: The name of the attribute to retrieve.
        :return: The value of the attribute if found.
        :raises AttributeError: If the attribute is not found.
        """
        if name in attributes:
            return attributes[name]
        elif base_class is not None:
            for classBase in base_class: # Checks in the base_class list if it's not empty.
                c = classBase['get'](name) # Checks each class in the list
                if c is not None:
                    return c # The name in the classBase

    def set_value(name, value):
        """
        Set the value of an attribute in the class.

        :param name: The name of the attribute to set.
        :param value: The value to assign to the attribute.
        """
        attributes[name] = value

    def new(*args):
        """
        Create a new instance of the class.

        :param args: Arguments to pass to the class constructor (__init__).
        :return: A new instance of the class.
        """
        return init_instance(cls, args)

    cls = {'get': get_value, 'set': set_value, 'new': new, 'attributes': attributes}
    return cls


def bind_method(value, instance):
    """Return a bound method if value is callable, or value otherwise."""
    if callable(value):
        def method(*args):
            return value(instance, *args)
        return method
    else:
        return value

def init_instance(cls, args):
    """
    Create a new instance of a class and initialize it using the provided arguments.

    :param cls: The class (dispatch dictionary) to instantiate.
    :param args: Arguments to pass to the class constructor (__init__).
    :return: An initialized instance of the class.
    """
    instance = make_instance(cls)
    init = cls['get']('__init__')
    if init:
        init(instance, *args)  # Pass all arguments directly to init
    return instance

def make_instance(cls):
    """
    Create a new instance of a class as a dispatch dictionary.

    :param cls: The class (dispatch dictionary) to create an instance of.
    :return: A new instance (dispatch dictionary).
    """
    attributes = {}

    def get_value(name):
        """
        Retrieve the value of an attribute from the instance or its class.

        :param name: The name of the attribute to retrieve.
        :return: The value of the attribute if found.
        """
        if name in attributes:
            return attributes[name] # If the name is in the attributes dictionary, return the value
        else:
            value = cls['get'](name)
            return bind_method(value, instance) # If the name is not in the attributes dictionary, return the value of the class

    def set_value(name, value):
        """
        Set the value of an attribute in the instance.

        :param name: The name of the attribute to set.
        :param value: The value to assign to the attribute.
        """
        attributes[name] = value # Set the value of the attribute in the instance

    instance = {'get': get_value, 'set': set_value, 'attributes': attributes}
    return instance


def make_my_date_class():
    """
    Define the MyDate class with day, month, year attributes and methods for validation and formatting.

    :return: A MyDate class (dispatch dictionary).
    """
    def __init__(self, day=1, month=1, year=2020):
        self['get']('set_day')(day)
        self['get']('set_month')(month)
        self['get']('set_year')(year)

    def get_day(self):
        if 1 <= self['get']('day') <= 9:
            return '0' + str(self['get']('day'))
        else:
            return self['get']('day')

    def get_month(self):
        if 1 <= self['get']('month') <= 9:
            return '0' + str(self['get']('month'))
        else:
            return self['get']('month')

    def get_year(self):
        return self['get']('year')

    def set_day(self, day):
        if 1 <= day <= 31:
            self['set']('day', day)
        else:
            print('Invalid day, must be between 1 and 31. Day stays the same')

    def set_month(self, month):
        if 1 <= month <= 12:
            self['set']('month', month)
        else:
            print('Invalid month, must be between 1 and 12. Month stays the same')

    def set_year(self, year):
        if 1900 <= year <= 2100:
            self['set']('year', year)
        else:
            print('Invalid year, must be between 1900 and 2100. Year stays the same')

    def __str__(self):
        return f"{self['get']('day'):02d}.{self['get']('month'):02d}.{self['get']('year')}"

    def __repr__(self):
        return "myDate['new']({0},{1},{2})".format(self['get']('get_day')(), self['get']('get_month')(), self['get']('get_year')())

    return make_class(locals())

myDate = make_my_date_class() # When We Will Want To Create "make_my_date_class" We Will write myDate['new']...
                              # And Won't Create New Scope Of "make_my_date_class" in each New Instance

def make_person_class():
    """
    Define the Person class with attributes like first_name, last_name, dob, and id.

    :return: A Person class (dispatch dictionary).
    """
    def __init__(self, first_name, last_name, dob, id):
        self['get']('set_first_name')(first_name)
        self['get']('set_last_name')(last_name)
        self['get']('set_dob')(dob)
        self['get']('set_id')(id)

    def get_first_name(self):
        return self['get']('first_name')
    def get_last_name(self):
        return self['get']('last_name')
    def get_dob(self):
        return self['get']('dob')
    def get_id(self):
        return self['get']('id')

    def set_first_name(self, first_name):
        self['set']('first_name', first_name)
    def set_last_name(self, last_name):
        self['set']('last_name', last_name)
    def set_dob(self, dob):
        self['set']('dob', dob)
    def set_id(self, id):
        self['set']('id', id)

    def __str__(self):
        return f"Name: {self['get']('first_name')} {self['get']('last_name')}\nDoB: {self['get']('dob')['get']('__str__')()}\nID: {self['get']('id')}"

    def __repr__(self):
        return "Person['new']({0},{1},{2},{3})".format(self['get']('get_first_name')(),
                                                       self['get']('get_last_name')(),
                                                       self['get']('dob')['get']('__repr__')(),
                                                       self['get']('get_id')())

    return make_class(locals())

Person=make_person_class()# When We Will Want To Create "make_person_class" We Will write Person['new']...
                          # And Won't Create New Scope Of "make_person_class" in each New Instance

def make_student_class():
    """
    Define the Student class inheriting from Person, with additional attributes like major, average, and years_studied.

    :return: A Student class (dispatch dictionary).
    """
    def __init__(self, first_name, last_name, dob, id, major, average, years_studied):
        Person['get']('__init__')(self, first_name, last_name, dob, id)
        self['get']('set_major')(major)
        self['get']('set_average')(average)
        self['get']('set_years_studied')(years_studied)

    def get_major(self):
        return self['get']('major')
    def get_average(self):
        return self['get']('average')
    def get_years_studied(self):
        return self['get']('years_studied')

    def set_major(self, major):
        self['set']('major', major)
    def set_average(self, average):
        self['set']('average', average)
    def set_years_studied(self, years_studied):
        self['set']('years_studied', years_studied)

    def __str__(self):
        return f"{Person['get']('__str__')(self)}\nLearning: {self['get']('major')}\nAvg: {self['get']('average')}\nSeniority: {self['get']('years_studied')} year(s)"
    def __repr__(self):
        return "Student['new']({0},{1},{2},{3},{4},{5},{6})".format(self['get']('get_first_name')(),
                                                                    self['get']('get_last_name')(),
                                                                    self['get']('dob')['get']('__repr__')(),
                                                                    self['get']('get_id')(),
                                                                    self['get']('get_major')(),
                                                                    self['get']('get_average')(),
                                                                    self['get']('get_years_studied')())
    return make_class(locals(), [Person])

Student = make_student_class() # When We Will Want To Create "make_student_class" We Will write Student['new']...


def make_faculty_class():
    """
    Define the Faculty class inheriting from Person, with additional attributes like department, salary, and years_worked.

    :return: A Faculty class (dispatch dictionary).
    """
    def __init__(self, first_name, last_name, dob, id, department, salary, years_worked):
        Person['get']('__init__')(self, first_name, last_name, dob, id)
        self['get']('set_department')(department)
        self['get']('set_salary')(salary)
        self['get']('set_years_worked')(years_worked)

    def get_department(self):
        return self['get']('department')
    def get_salary(self):
        return self['get']('salary')
    def get_years_worked(self):
        return self['get']('years_worked')

    def set_department(self, department):
        self['set']('department', department)
    def set_salary(self, salary):
        self['set']('salary', salary)
    def set_years_worked(self, years_worked):
        self['set']('years_worked', years_worked)

    def __str__(self):
        return f"{Person['get']('__str__')(self)}\nTeaching: {self['get']('department')}\nSalary: {self['get']('salary')}\nSeniority: {self['get']('years_worked')} year(s)"
    def __repr__(self):
        return "Faculty['new']({0},{1},{2},{3},{4},{5},{6})".format(self['get']('get_first_name')(),
                                                                    self['get']('get_last_name')(),
                                                                    self['get']('dob')['get']('__repr__')(),
                                                                    self['get']('get_id')(),
                                                                    self['get']('get_department')(),
                                                                    self['get']('get_salary')(),
                                                                    self['get']('get_years_worked')())
    return make_class(locals(), [Person])

Faculty = make_faculty_class() # When We Will Want To Create "make_faculty_class" We Will write Faculty['new']...
                               # And Won't Create New Scope Of "make_faculty_class" in each New Instance

def make_ta_class():
    """
    Define the TA class inheriting from Student and Faculty.
    :return: A TA class (dispatch dictionary).
    """
    def __init__(self, first_name, last_name, dob, id, major, average, years_studied, department, salary, years_worked):
        Student['get']('__init__')(self, first_name, last_name, dob, id, major, average, years_studied)
        Faculty['get']('__init__')(self, first_name, last_name, dob, id, department, salary, years_worked)

    def __str__(self):
        return f"{Student['get']('__str__')(self)}\nTeaching: {Faculty['get']('get_department')(self)}\nSalary: {Faculty['get']('get_salary')(self)}\nSeniority (in teaching): {Faculty['get']('get_years_worked')(self)} year(s)"

    def __repr__(self):
        return "TA['new']({0},{1},{2},{3},{4},{5},{6},{7},{8},{9})".format(self['get']('get_first_name')(),
                                                                           self['get']('get_last_name')(),
                                                                           self['get']('dob')['get']('__repr__')(),
                                                                           self['get']('get_id')(),
                                                                           self['get']('get_major')(),
                                                                           self['get']('get_average')(),
                                                                           self['get']('get_years_studied')(),
                                                                           self['get']('get_department')(),
                                                                           self['get']('get_salary')(),
                                                                           self['get']('get_years_worked')())
    return make_class(locals(),[Student, Faculty])

TA = make_ta_class() # When We Will Want To Create "make_ta_class" We Will write TA['new']...
                     # And Won't Create New Scope Of "make_ta_class" in each New Instance


# Example of using the classes
def test_run():
    """
    This function is used as an example to run the classes and print the results
    :return: None
    """
    DoB1 = myDate['new'](30, 12, 2001)
    DoB2 = myDate['new'](14,6,2001)
    DoB3 = myDate['new'](3,8,2025)
    Jordan = Person['new']('Jordan', 'Daudu', DoB1, 123456789)
    Joe = Student['new']('Joe', 'Bensimon', DoB2, 340854377, 'Software Engineer', 100, 2)
    Tammar = Faculty['new']('Tammar', 'Shrot', DoB3, 987654321, 'Software Engineer', 1000.0, 3)
    Beni = TA['new']('Beni', 'Cohen', DoB3, 152486397, 'Software Engineer', 98.0, 3, 'Software Engineer', 1000.0, 2)
    print(Jordan['get']('__str__')())
    print("=====================================")
    print(Joe['get']('__str__')())
    print("=====================================")
    print(Tammar['get']('__str__')())
    print("=====================================")
    print(Beni['get']('__str__')())


# Question 2
def read_eval_print_loop():
    """Run a read-eval-print loop for the calculator.
    Continuously prompts the user for input, parses and evaluates the expression,
    and prints the result. Handles errors and allows exiting with keyboard commands.
    """
    while True:
        try:
            expression_tree = calc_parse(input('calc>  '))  # start running
            print(calc_eval(expression_tree))
        except (SyntaxError, TypeError, ZeroDivisionError) as err:  # errors
            print(type(err).__name__ + ':', err)
        except (KeyboardInterrupt, EOFError):  # <Control>-D, end of running
            print('Calculation completed.')
            return

class Exp(object):
    """Represents a call expression in the calculator.
    Stores an operator and its operands as an expression tree.

    Attributes:
        operator (str): The operator to apply.
        operands (list): The operands for the operator.
    """
    def __init__(self, operator, operands):
        self.operator = operator
        self.operands = operands

    def __repr__(self):
        return 'Exp({0}, {1})'.format(repr(self.operator), repr(self.operands))

    def __str__(self):
        operand_strs = ', '.join(map(str, self.operands))
        return '{0}({1})'.format(self.operator, operand_strs)

def calc_eval(exp):
    """Evaluate a calculator expression.

    Args:
        exp (int, float, Exp): The expression to evaluate.

    Returns:
        int or float: The result of the evaluation.
    """
    if type(exp) in (int, float):  # Primitive expression
        return exp
    if type(exp) == Exp:
        arguments = list(map(calc_eval, exp.operands))  # List of operands
        return calc_apply(exp.operator, arguments)  # Activation of the operator on the operands

def calc_apply(operator, args):
    """Apply the named operator to a list of arguments.

    Args:
        operator (str): The operator to apply.
        args (list): The list of arguments to process.

    Returns:
        int or float: The result of the operation.

    Raises:
        TypeError: If the operator or arguments are invalid.
    """
    if operator in ('add', '+'):
        return sum(args)
    if operator in ('sub', '-'):
        if len(args) == 0:  # empty list
            raise TypeError(operator + ' requires at least 1 argument')
        if len(args) == 1:  # one arg in the list
            return -args[0]  # return negative value
        return sum(args[:1] + [-arg for arg in args[1:]])  # Activation of subtraction
    if operator in ('mul', '*'):
        return reduce(mul, args, 1)  # Activating a multiplication operation
    if operator in ('div', '/'):
        if len(args) != 2:  # A division operation is performed on only 2 arguments
            raise TypeError(operator + ' requires exactly 2 arguments')
        numer, denom = args
        return numer / denom
    if operator in ('power', '^'):
        if len(args) != 2:  # A power operation is performed on only 2 arguments
            raise TypeError(operator + ' requires 2 arguments')
        Base, Power = args
        return pow(Base, Power)  # Activating a power operation
    if operator in ('modolo', '%'):
        if len(args) != 2:  # A modulo operation is performed on only 2 arguments
            raise TypeError(operator + ' requires 2 arguments')
        num1, num2 = args
        return mod(num1, num2)  # Activating a modulo operation

def calc_parse(line):
    """Parse a line of calculator input and return an expression tree.

    Args:
        line (str): The input line to parse.

    Returns:
        int, float, or Exp: The parsed expression tree.

    Raises:
        SyntaxError: If the input is invalid.
    """
    tokens = tokenize(line)
    expression_tree = analyze(tokens)
    if len(tokens) > 0:  # If tokens remain
        raise SyntaxError('Extra token(s): ' + ' '.join(tokens))
    return expression_tree

def tokenize(line):
    """Convert a string into a list of tokens.

    Args:
        line (str): The input string to tokenize.

    Returns:
        list: The list of tokens.
    """
    spaced = line.replace('(', ' ( ').replace(')', ' ) ').replace(',', ' , ')
    return spaced.strip().split()

known_operators = ['add', 'sub', 'mul', 'div', '+', '-', '*', '/', 'modolo', '%', 'power', '^']

def analyze(tokens):
    """Create a tree of nested lists from a sequence of tokens.

    Args:
        tokens (list): The list of tokens to analyze.

    Returns:
        int, float, or Exp: The analyzed expression tree.

    Raises:
        SyntaxError: If the tokens do not form a valid expression.
    """
    assert_non_empty(tokens)  # not empty list
    token = analyze_token(tokens.pop(0))
    if type(token) in (int, float):  # Primitive expression
        return token
    if token in known_operators:
        if len(tokens) == 0 or tokens.pop(0) != '(':
            raise SyntaxError('expected ( after ' + token)
        return Exp(token, analyze_operands(tokens))  # Recursive call to analyze_operands func
    else:
        raise SyntaxError('unexpected ' + token)  # Action does not exist

def analyze_operands(tokens):
    """Analyze a sequence of comma-separated operands.

    Args:
        tokens (list): The list of tokens representing operands.

    Returns:
        list: The list of analyzed operands.

    Raises:
        SyntaxError: If the operands are not properly formatted.
    """
    assert_non_empty(tokens)  # not empty list
    operands = []
    while tokens[0] != ')':  # end of expression
        if operands and tokens.pop(0) != ',':
            raise SyntaxError('expected ,')
        operands.append(analyze(tokens))  # Recursive call to analyze func
        assert_non_empty(tokens)  # not empty list
    tokens.pop(0)  # Remove )
    return operands  # Returns a list of operands

def assert_non_empty(tokens):
    """Raise an exception if the list of tokens is empty.

    Args:
        tokens (list): The list of tokens.

    Raises:
        SyntaxError: If the token list is empty.
    """
    if len(tokens) == 0:
        raise SyntaxError('unexpected end of line')

def analyze_token(token):
    """Return the value of a token if it can be analyzed as a number, or the token itself.

    Args:
        token (str): The token to analyze.

    Returns:
        int, float, or str: The analyzed token.
    """
    try:
        return int(token)
    except (TypeError, ValueError):  # No legal number or token in the language
        try:
            return float(token)
        except (TypeError, ValueError):  # No legal number or token in the language
            return token

read_eval_print_loop()


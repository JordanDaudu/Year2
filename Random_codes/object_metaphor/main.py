def bind_method(value, instance):
    """Return a bound method if value is callable, or value otherwise."""
    if callable(value):
        def method(*args):
            return value(instance, *args)
        return method
    else:
        return value

def make_instance(cls):
    """
    Return a new object instance, which is a dispatch dictionary.
    """
    attributes = {}
    def get_value(name):
        if name in attributes:
            return attributes[name]
        else:
            value = cls['get'](name)
            return bind_method(value, instance)
    def set_value(name, value):
        attributes[name] = value
    instance = {'get': get_value, 'set': set_value}
    return instance

def make_class(attributes, base_class=None):
    """Return a new class, which is a dispatch dictionary."""

    def get_value(name):
        if name in attributes:
            return attributes[name]
        elif base_class is not None:
            return base_class['get'](name)

    def set_value(name, value):
        attributes[name] = value

    def new(*args):
        return init_instance(cls, *args)

    cls = {'get': get_value, 'set': set_value, 'new': new}
    return cls

def init_instance(cls, *args):
    """Return a new object with type cls, initialized with args."""
    instance = make_instance(cls)
    init = cls['get']('__init__')
    if init:
        init(instance, *args)
    return instance


def make_account_class():
    """Return the Account class, which has deposit and withdraw methods."""

    def __init__(self, account_holder):
        """Initialize the account with a holder and a starting balance of 0."""
        self['set']('holder', account_holder)
        self['set']('balance', 0)

    def deposit(self, amount):
        """Increase the account balance by amount and return the new balance."""
        new_balance = self['get']('balance') + amount
        self['set']('balance', new_balance)
        return self['get']('balance')

    def withdraw(self, amount):
        """Decrease the account balance by amount and return the new balance."""
        balance = self['get']('balance')
        if amount > balance:
            return 'Insufficient funds'
        self['set']('balance', balance - amount)
        return self['get']('balance')

    # Define the Account class using make_class
    return make_class({
        '__init__': __init__,
        'deposit': deposit,
        'withdraw': withdraw,
        'interest': 0.02
    })


Account = make_account_class()

jordan_account = Account['new']('Jordan')	# Create an account for Jordan
print(jordan_account['get']('holder'))	# 'Jordan'
print(jordan_account['get']('balance'))	# 0
print(jordan_account['get']('deposit')(15))	# 15
print(jordan_account['get']('withdraw')(10))	# 5
print(jordan_account['get']('withdraw')(10))	# 'Insufficient funds'
print(jordan_account['get']('balance'))	# 5
def make_account(balance, owner):
    """
    Return a dispatch function that represents a bank account.
    Provides methods to withdraw, deposit, and retrieve balance or owner information.
    """
    def withdraw(amount):
        """Withdraw the specified amount from the account if funds are sufficient."""
        nonlocal balance
        if amount > balance:
            return 'Insufficient funds'
        balance -= amount
        return balance

    def deposit(amount):
        """Deposit the specified amount into the account."""
        nonlocal balance
        balance += amount
        return balance

    def get_balance():
        """Return the current balance of the account."""
        return balance

    def get_owner():
        """Return the owner of the account."""
        return owner

    def dispatch(msg):
        """Dispatch method to access account operations."""
        if msg == 'withdraw':
            return withdraw
        elif msg == 'deposit':
            return deposit
        elif msg == 'get_balance':
            return get_balance
        elif msg == 'get_owner':
            return get_owner

    return dispatch


jordan = make_account(1000, 'Jordan')
print(jordan('get_balance')())  # 1000
print(jordan('withdraw')(100))  # 900
print(jordan('deposit')(50))  # 950
print(jordan('get_owner')())  # Jordan
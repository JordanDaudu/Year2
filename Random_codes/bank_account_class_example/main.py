class Account:
    """A simple Account class to manage deposits, withdrawals, and balance tracking."""

    def __init__(self, account_holder):
        """
        Initialize an account with a holder and a starting balance of 0.

        Parameters:
        account_holder (str): The name of the account holder.
        """
        self.balance = 0
        self.holder = account_holder

    def deposit(self, amount):
        """
        Deposit the specified amount into the account and return the new balance.

        Parameters:
        amount (float): The amount to deposit.

        Returns:
        float: The new balance.
        """
        self.balance += amount
        return self.balance

    def withdraw(self, amount):
        """
        Withdraw the specified amount from the account if funds are sufficient.
        Returns a message if funds are insufficient.

        Parameters:
        amount (float): The amount to withdraw.

        Returns:
        float or str: The new balance or a message if insufficient funds.
        """
        if amount > self.balance:
            return 'Insufficient funds'
        self.balance -= amount
        return self.balance


jordan_account = Account('Jordan')
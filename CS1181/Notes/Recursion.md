Recursion

    Algorithm
        A sequence of steps for soilving a problem.
            Ex. Make Lemonade: add sugar, add lemon juice, add water, stir

    Recursive Algorithm
        An algorithm that breaks the problem into smaller subproblems and applies the same algorithm to solve the smaller subproblems.
            Ex. Mow the lawn: 
                Mow the frontyard: mow the left front, mow the right front
                Moew the backyard: mow the left back, mow the right back

Recursive Methods

    Recursive Method:
        A method that calls itself.

Recursive Algorithm: Search
    Binary Search
        An algorithm that begins at the midpoint of a range and halves the range after each guess.
        Ex. (range is 0 - 100)
        Is it 50 (middle of 0 and 100)? Lower
        Is it 25 (middle of 0 and 450)? Higher
        Is it 38 (middle of 26 and 50)? Lower
        Is it 32 (middle of 26 and 38)

Creating a Recursive Method
    Write the base case:
        Every recursive method must have a case that returns a value without performing a recursive call. That case is called the base case. A programmer may write that part of the method first, and then test. There may be multiple base cases.
    Write the recursive call:
        The programmer then adds the recursive case to the method.
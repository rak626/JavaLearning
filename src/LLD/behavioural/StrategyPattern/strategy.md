### Problem (UseCase)

    - duplicate code in same child level.

### Solution

    1. convert the functionality to interface.
    2. implement this functionality interface to different Strategy.
    3. use this strategy in runtime, so that classes are loosely coupled.
    4. then repetion of work is less as we write that code in our strategy.


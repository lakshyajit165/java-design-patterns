## Factory Design Pattern properties

- Creational design pattern.
- Used when we have multiple sub classes of a super class & based on input we want to return one class instance.
- It provides abstraction between implementation and client classes.
- Helps remove the instantiation of client classes form client code.

### Implementation

- Super class can be an interface or abstract class or basic class.
- Factory class has a static method which returns the instance of subclass based on input.
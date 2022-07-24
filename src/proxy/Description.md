## Proxy Design Pattern - Properties

- Structural Design Pattern
- Used when you want to control access i.e. in Databases, you would want to control the 'delete' query to be available for only certain users like admin.

### Implementation

- In general we've a class which is executing interface executor method which is executing all the commands.
- To control this, we add a proxy class which implements the same interface & write conditions  for 'admin' user before proceeding to the actual executor.
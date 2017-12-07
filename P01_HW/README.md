# Find the biggest number in the given input array
First Java homework was focused on finding max value(s) from input double array

## Issues
1. Problem to run ParameterizedTest in JUnit 5
	* Temporarily solved by writing many methods with different input
2. Is the "array" solution still O(n)?

## Findings
1. assertThrows with lambda expressions for testing exceptions

## Questions
1. Should we use @BeforeAll for init?
	* Answer: Let's use @BeforeEach for init
2. How to use ParameterizedTest in JUnit 5?
	* Should @MethodSource be used?
	* It is not recommended to use ParameterizedTest. Only if you need to validate several different inputs  
3. Does it make sense to add code coverage to projects?
4. Should I init string array with empty values?
	* NO! Let's use null because empty string is valid value

## Missing functionality
Order String array with lower case values


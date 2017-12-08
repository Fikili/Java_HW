# Create Ssn (Social security number) validator for Finns

*	Rules for Ssn is defined in https://en.wikipedia.org/wiki/National_identification_number 
*	Use http://www.fakenamegenerator.com for generating test values.

## Issues
1.	

## Findings
1.	ResolverStyle.STRICT use for exact days (not 32 Jan -> 1 Feb and so on)
	* See https://stackoverflow.com/a/39649815/2886891
	
## Questions
1.	Should we catch DateTimeParseException and return false? For example SsnValidatorTest.isValidSemanticsWrongDay
	* Answer: 
2.	Should we create a more test classes if there are many test cases?
	* Answer: 
3. Is it good approach to create a static map for control character - remainder mapping?
	* Answer: 

## Missing functionality
1.	Should we implement ZZZ (Individual number) check for woman/man differences?


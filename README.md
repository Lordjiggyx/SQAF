
# Introduction

This assignment revolves around the use of gitflow and testing. The main objective of this assignment is to create a software component that stores information about surveys and responses.

This component does not have a user interface or connection to external storage. It only contains a "controller" class with methods that support various features the only way to know if the code successfully works is through a test suite created using JUnit. I followed a Test-Driven development approach when creating this project and each commit contains tests and the appropriate code.

This assignment requires me to also have the following sections :

* A scrum sprint backlog and a estimation of the tasks i wanted to complete

* A section detailing TDD(Test Driven Development) and how I created this project following this methodology.

* A section detailing a code coverage tool that I selected, why I selected it and how I used the tool

* A pull review checklist detailing a number of checks that a reviewer other than myself would make in the process of making pull requests

# Sprint Backlog 

This sprint backlog contains a list of tasks and the corresponding estimation associated with each task.

### Task estimation

To create estimations for my tasks I decided to go with what is known as "T-Shirt Sizing" this is a from of estimation used to size items in a sprint backlog. Items can be classified using t-shirt sizes (e.g. XS,S,M,L,XL). In this technique members of a team  would give each an item to size and at the end compare all estimates given. If all estimates are the same, that is considered as the ideal size, if not, then discuss among the team to arrive at the same estimate.

Because this assignment was not a team effort I had to create my own criteria for determining the size of an item. To do this I decided to base my t-shirt sizes off the complexity of the code that was associated with a task, the criteria followed as such:

Does the task.....

1. have method/methods that return a value?
2. include some sort of arithmetic operation?
3. include iterating through a collection?
4. include if/switch statements?
5. include creating new objects?
6. require a test?
7. include a loop?
8. include extracting information from an element in a collection?
9. include a method that takes in parameters


* If a task answers yes to less then 3 of the following questions it was deemed an S task.
* If a task answers yes to more then 3 but less then 7 of the following questions it was deemed an M task.
* If a task answers yes to 7 or more of the following questions it was deemed an L task.

### Tasks

**Initial tasks and estimates**

A list of the initial tasks and estimations.

* Create new survey - S
* Add a question to a survey - S
* Get a list of all surveys - M
* Get a survey by name - M
* Creating a survey response - S
* Adding an answer to a survey response - S
* Getting all survey responses associated with a specific survey - L
* Get average deviation of a survey  - L
* Get standard deviation of a survey - L
* Get maximum score of a survey - L
* Get minimum score of a survey - L
* Get standard deviation for a specific question on a survey - L
* Get maximum score for a specific question on a survey - L
* Get minimum score for a specific question on a survey - L

**Additional Tasks**
* Get the sum value of question answers in a survey response - L
* Ensure a question answer value is between 1-5 - M
* Get a list of all surveys - M



**Task Comparison**

Two tasks that I will compare are:

1. Get average deviation of a survey
2. Add a question to a survey


| Question 	| Task 1 	| Task 2 	|
|----------	|--------	|--------	|
| 1        	| Yes    	| No     	|
| 2        	| Yes    	| No     	|
| 3        	| Yes    	| No     	|
| 4        	| NO     	| No     	|
| 5        	| NO     	| Yes    	|
| 6        	| Yes    	| Yes    	|
| 7        	| Yes    	| No     	|
| 8        	| Yes    	| No     	|
| 9        	| Yes    	| No     	|
| SUM      	| 7      	| 2      	|


As we can see task one answers yes to 7 questions meaning the it is L while task 2 only answers yes to 2 meaning that it is S 

**Velocity Metric Calculation**

I decided to give each t-shirt size a corresponding numerical value S = 1 , M = 2 , L = 3

To calculation of the velocity metric follows as:

* get the number of tasks completed by t-shirt size e.g. [s:2 ,m:3, l:1]
* multiply the number value of the tasks completed by the numerical value assigned to each t-shirt size e.g. [s:2x1, m:3x2, l:3x1] = [s:2, m:6, l:3]
* get the sum of the numerical values calculated e.g. 2+6+1 = 9
* divided the sum by 3 because there are 3 t-shirt sizes to get the velocity metric e.g. 9/3 = 3

I would use this velocity metric to determine how fast the team is working in relation to the task sizes , the greater the number the more tasks getting completed.

# Test-Driven Development

Test-driven development (TDD) is a software development process that relies on the repetition of a very short development cycle: first the developer writes an (initially failing) automated test case that defines a desired improvement or new function, then produces the minimum amount of code to pass that test, and finally refactors the new code to acceptable standards.


In this [commit](https://github.com/Lordjiggyx/SQAF/commit/8f7443e27b3ca45ebcd074a796332a1483fd9403) I created 5 tests for the initial survey response object each one of these test were failing test, the methods or objects were not present or not correctly implemented.

The next 5 commits show the changing of code which allowed the tests to pass

* [Test 1](https://github.com/Lordjiggyx/SQAF/commit/d11f38f5fa6fde0cba27d090886f63fc6c673d03) - This commit shows the creation of the Survey Response class and how i implement it in the Question class, I also had to change the test to check for an instance of survey class being created.

* [Test 2](https://github.com/Lordjiggyx/SQAF/commit/b3829374824ccbd9b662235e2ccc9021966159e1) - This commit shows mw changing the way i used the Junit Assertion i wanted to check that the value set to the answer was the hardcoded value i had given it rather then an empty value or null.

* [Test 3](https://github.com/Lordjiggyx/SQAF/commit/8d7e25f4ce8b32d464770536ee830be88f1b5c3e) - This commit shows me changing the setAnswer method to determine if a value is set between 1-5 if it is the answer is set to 0 (This is later chnaged to an IllegalArgumentException)

* [Test 4](https://github.com/Lordjiggyx/SQAF/commit/987c944233fdc15e9e1a17c2a17a84ba22fe3e38) - This commit shows me uncommenting the test created in the first commit.

* [Test 5](https://github.com/Lordjiggyx/SQAF/commit/836b38a555c7d3205c5c51fae3f7b4d230289d0c) - This commit shows me creating a method in the Survey class that gets an array for the question answers in a survey Response and the correspsonding test


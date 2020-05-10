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


* If a task answers yes to less then 3 of the following questions it was deemed an S task.
* If a task answers yes to more then 3 but less then 6 of the following questions it was deemed an M task.
* If a task answers yes to more then 6 of the following questions it was deemed an L task.




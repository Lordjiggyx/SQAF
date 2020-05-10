# Introduction

This assignment revolves around the use of gitflow and testing. The main objective of this assignment is to create a software component that stores information about surveys and responses.

This component does not have a user interface or connection to external storage. It only contains a "controller" class with methods that support various features the only way to know if the code successfully works is through a test suite created using JUnit. I followed a Test-Driven development approach when creating this project and each commit contains tests and the appropriate code.

This assignment requires me to also have the following sections :

* A scrum sprint backlog and a estimation of the tasks i wanted to complete

* A section detailing TDD(Test Driven Development) and how I created this project following this methodology.

* A section detailing a code coverage tool that I selected, why I selected it and how I used the tool

* A pull review checklist detailing a number of checks that a reviewer other than myself would make in the process of making pull requests


# Review Checklist

### What is a code review?

A code review is the process by which programmers examine the code of their peers. In order to share knowledge with each other as well as 
checking for bugs and to estimate the code quality. It has been shown to accelerate and streamline the software development process.

A code review involves checking for things like :
 * Obvious logic errors in the code.
 * Have the requirements for each use case been implemented?
 * Are the current tests sufficient for the new code, will new tests need to be written?
 
My checklist included the following:

#### Pull request format

1. Name of pull request in the form " Pull Request Title:_____ "
2. Each pull request should address only one issue 
3. Each commit in the pull request has a meaningful commit message

#### Modifications

**Briefly describe the changes made**

#### Verification of change

**Can only be one of the following**

1. Trivial change - syntax , grammar , code cleanup no need for test
2. Change is already covered by existing tests
3. Change required addition of tests

#### Feature
1. Does this pull request introduce a new feature? (yes / no)
2. If yes how is this feature tested / if no was this a bug fix (yes/no)


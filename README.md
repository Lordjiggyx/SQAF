# Introduction

This assignment revolves around the use of gitflow and testing. The main objective of this assignment is to create a software component that stores information about surveys and responses.

This component does not have a user interface or connection to external storage. It only contains a "controller" class with methods that support various features the only way to know if the code successfully works is through a test suite created using JUnit. I followed a Test-Driven development approach when creating this project and each commit contains tests and the appropriate code.

This assignment requires me to also have the following sections :

* A scrum sprint backlog and a estimation of the tasks i wanted to complete

* A section detailing TDD(Test Driven Development) and how I created this project following this methodology.

* A section detailing a code coverage tool that I selected, why I selected it and how I used the tool

* A pull review checklist detailing a number of checks that a reviewer other than myself would make in the process of making pull requests


# Test-Driven Development

Test-driven development (TDD) is a software development process that relies on the repetition of a very short development cycle: first the developer writes an (initially failing) automated test case that defines a desired improvement or new function, then produces the minimum amount of code to pass that test, and finally refactors the new code to acceptable standards.


In this [commit](https://github.com/Lordjiggyx/SQAF/commit/8f7443e27b3ca45ebcd074a796332a1483fd9403) I created 5 tests for the initial survey response object each one of these test were failing test, the methods or objects were not present or not correctly implemented.

The next 5 commits show the changing of code which allowed the tests to pass

* [Test 1](https://github.com/Lordjiggyx/SQAF/commit/d11f38f5fa6fde0cba27d090886f63fc6c673d03) - This commit shows the creation of the Survey Response class and how i implement it in the Question class, I also had to change the test to check for an instance of survey class being created.

* [Test 2](https://github.com/Lordjiggyx/SQAF/commit/b3829374824ccbd9b662235e2ccc9021966159e1) - This commit shows mw changing the way i used the Junit Assertion i wanted to check that the value set to the answer was the hardcoded value i had given it rather then an empty value or null.

* [Test 3](https://github.com/Lordjiggyx/SQAF/commit/8d7e25f4ce8b32d464770536ee830be88f1b5c3e) - This commit shows me changing the setAnswer method to determine if a value is set between 1-5 if it is the answer is set to 0 (This is later chnaged to an IllegalArgumentException)

* [Test 4](https://github.com/Lordjiggyx/SQAF/commit/987c944233fdc15e9e1a17c2a17a84ba22fe3e38) - This commit shows me uncommenting the test created in the first commit.

* [Test 5](https://github.com/Lordjiggyx/SQAF/commit/836b38a555c7d3205c5c51fae3f7b4d230289d0c) - This commit shows me creating a method in the Survey class that gets an array for the question answers in a survey Response and the correspsonding test


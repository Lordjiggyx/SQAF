# Introduction

This assignment revolves around the use of gitflow and testing. The main objective of this assignment is to create a software component that stores information about surveys and responses.

This component does not have a user interface or connection to external storage. It only contains a "controller" class with methods that support various features the only way to know if the code successfully works is through a test suite created using JUnit. I followed a Test-Driven development approach when creating this project and each commit contains tests and the appropriate code.

This assignment requires me to also have the following sections :

* A scrum sprint backlog and a estimation of the tasks i wanted to complete

* A section detailing TDD(Test Driven Development) and how I created this project following this methodology.

* A section detailing a code coverage tool that I selected, why I selected it and how I used the tool

* A pull review checklist detailing a number of checks that a reviewer other than myself would make in the process of making pull requests


# Team Version Control

To manage version control for this project i used the gitflow process. This included creating branches when I created a new feature and merging the branches accordingly. I decided to create 4 main branches 

##### Master
This branch is where the final project containing all documentation and code would be located no changes to this branch are allowed, only pull requests from the develop branch are allowed

##### Develop
This branch is where any near final changes are located before making it into the master branch this branch only takes pull requests from either the Docbranch or Devbranch.

##### DevBranch
This branch is includes any final additional features to the actual code of the project, pull requests for this branch must be from a branch with the following format <BRANCH_NAME-DEV>.

##### DocBranch
This branch is includes any final additional features/sections to the documentation of the project, pull requests for this branch must be from a branch with that does not follow the Devbranch naming format.

the other branches in the project are created to add additional content to these 4 branches. each branch will be merged to one of the following four branches and then to the develop branch only upon project completion will the develop branch be merged to the master branch and a release will be created








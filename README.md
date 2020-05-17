# Introduction

This assignment revolves around the use of gitflow and testing. The main objective of this assignment is to create a software component that stores information about surveys and responses.

This component does not have a user interface or connection to external storage. It only contains a "controller" class with methods that support various features the only way to know if the code successfully works is through a test suite created using JUnit. I followed a Test-Driven development approach when creating this project and each commit contains tests and the appropriate code.

This assignment requires me to also have the following sections :

* A scrum sprint backlog and a estimation of the tasks i wanted to complete

* A section detailing TDD(Test Driven Development) and how I created this project following this methodology.

* A section detailing a code coverage tool that I selected, why I selected it and how I used the tool

* A pull review checklist detailing a number of checks that a reviewer other than myself would make in the process of making pull requests


# Team Version Control


To manage version control for this project I used the gitflow process.

## What is the Gitflow

Gitflow is a workflow process that defines a branching model for a scheduled project release.This is used mainly for managing large projects. The master branch and the develop branches are used to record the project history and the remaining branches can fall into many categories of branches e.g feature branches , hotfix branches and release branches.

## My Branches

##### Master
This branch is where the final project containing all documentation and code would be located no changes to this branch are allowed, only pull requests from the develop branch are allowed

##### Develop
This branch is where any near final changes are located before making it into the master branch this branch only takes pull requests from either the Docbranch or Devbranch.

##### DevBranch
This branch is includes any final additional features to the actual code of the project, pull requests for this branch must be from a branch with the following format <BRANCH_NAME-DEV>.

##### DocBranch
This branch is includes any final additional features/sections to the documentation of the project, pull requests for this branch must be from a branch with that does not follow the Devbranch naming format.

the other branches in the project are created to add additional content to these 4 branches. each branch will be merged to one of the following four branches and then to the develop branch only upon project completion will the develop branch be merged to the master branch and a release branch will be created.

List of branches created:

* TDD - Branch containing Test Driven Development content for documentation

* SprintBacklog - Branch containing Sprint Backlog and task estimation  content for documentation

* MetricTool - Branch containing Test coverage content for documentation

* VersionControl - Branch containing Team version control content for documentation

* ReviewChecklist - Branch containing Sprint Backlog content for documentation

* Controller-DEV - building on all the pieces of code from the other branches this branch housed the controller and the test suite for the controller.

* Arithmetic1-DEV - Branch conatained the initial arithmetic operations that were corrected I had made a logical error in how i was conducting these operations which are explained in the [pull request](https://github.com/Lordjiggyx/SQAF/pull/7) related to this branch.

* Arithmetic-DEV - Branch conatained the initial arithmetic operations that were meant to be conducted on the survey class.

* Survey-DEV - Branch contained the initial code for the application with the creation of the survey and question classes including tests

* sSurveyResponse-DEV - Branch contained the code related to the survey response class including tests









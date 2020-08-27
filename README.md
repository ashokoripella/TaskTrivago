# TaskTrivago
Tools Used: Selenium, Cucumber.

Selenium is a Functional Automation tool for Web applications. It is not framework. Selenium is not just a single tool but a suite of software's, each catering to different testing needs of an organization. A cucumber is a tool based on Behavior Driven Development (BDD) framework which is used to write acceptance tests for the web application. It allows automation of functional validation in easily readable and understandable format.

Testing FrameWork Used: Junit. 
JUnit is a unit testing framework for Java programming language. JUnit promotes the idea of "first testing then coding", which emphasizes on setting up the test data for a piece of code that can be tested first and then implemented. It increases the productivity of the programmer and the stability of program code, which in turn reduces the stress on the programmer and the time spent on debugging.

Gerkhin: All test cases are designed in Gerkhin Format. 
Gherkin is a language that developers use to define tests in Cucumber. It’s meant to describe use cases for a software system in a way that can be read and understood by almost anyone. This promotes(BDD) Behavior-Driven Development because it allows developers, managers, business analysts and other parties involved to understand the requirements of the project and the life-cycle.

Results: Every test case result is attched in "TestResults" Folder.

Limitations used for tests: 
-->When it comes to performance testing, it seems to be very impractical in terms of manual testing. 
-->Designing a perfect automation script need some solid understanding of software development principles which automation testers lack most of the time. Thus everyone follow        their own standards while developing scripts. 
-->All functionalities for selenium are written in "SeleniumFunctions.java" and this class is Extended by all Steps classes. 
-->All Steps Classes are written their respective Names based on the scenarios in "stpDefinition" package. -->Used Natural 0.9 plugin for eclipse.
   It is a set of plugins providing a smooth experience in editing and maintaining BDD files. Currently supported to Cucumber (Gherkin syntax). 
-->Cucumber Eclipse Plugin 1.0.0.202005150629. -->Compliance level:jdk1.8.0_191 
-->All Dependencies such as seleniumhq, junit, cucumber-testng, cucumber-jvm-deps, etc are listed in pom.xml

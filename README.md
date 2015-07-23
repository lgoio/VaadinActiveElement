Vaadin Component Having Focus 
==============
This is a sample to show how to request in Vaadin the next component having focus using JavaScript [document.activeElement](http://www.w3schools.com/jsref/prop_document_activeelement.asp).

This project based on a Template for a simple Vaadin application that only requires a Servlet 3.0 container to run:

Workflow
========

To compile the entire project, run:

	mvn install
	
To run the application, run:
	
	mvn jetty:run

and open [http://localhost:8080/](http://localhost:8080/) .

To develop the theme, simply update the relevant theme files and reload the application.
Pre-compiling a theme eliminates automatic theme updates at runtime - see below for more information.

Debugging client side code
  - run "mvn vaadin:run-codeserver" on a separate console while the application is running
  - activate Super Dev Mode in the debug window of the application

To produce a deployable production mode WAR:
- change productionMode to true in the servlet class configuration (nested in the UI class)
- run "mvn clean vaadin:compile-theme package"
  - See below for more information. Running "mvn clean" removes the pre-compiled theme.
- test with "mvn jetty:run-war

Using a precompiled theme
-------------------------

When developing the application, Vaadin can compile the theme on the fly when needed,
or the theme can be precompiled to speed up page loads.

To precompile the theme run "mvn vaadin:compile-theme". Note, though, that once
the theme has been precompiled, any theme changes will not be visible until the
next theme compilation or running the "mvn clean" target.

When developing the theme, running the application in the "run" mode (rather than
in "debug") in the IDE can speed up consecutive on-the-fly theme compilations
significantly.

References
========
* [Creating a Vaadin Maven project](https://vaadin.com/wiki/-/wiki/Main/Creating+a+Maven+project)
* [HTML DOM activeElement Property](http://www.w3schools.com/jsref/prop_document_activeelement.asp)
* [Vaadin Integrating JavaScript Components and Extensions](https://vaadin.com/book/vaadin7/-/page/gwt.javascript.html)
* [Maven - POM: How to make the jetty port changeable](http://stackoverflow.com/questions/3334454/maven-pom-how-to-make-the-jetty-port-changeable-so-that-it-can-be-retrieved-l)
* [VAADIN cannot find themes when in productionMode](http://stackoverflow.com/questions/16561633/vaadin-cannot-find-themes-when-in-productionmode)
* [m2e plugin of Eclipse doesn't know of exec-maven-plugin](http://stackoverflow.com/questions/21721846/exec-maven-plugin1-2-1-in-ecipse)
[LPGL License](LICENSE)
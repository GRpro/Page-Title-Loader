Simple page title loader
========================

**Used technologies**
* Java
* Maven
* Selenium
* XPath
* Bash

Simple bot which finds using google searching result and then go to each page
in result list and prints page title in the console.

**How to run on Linux (Ubuntu)**
* Install browser Firefox
* Install Java 7 or higher
* Install Maven
* Go to root project's folder and add permission for executing start.sh: chmod a+x start.sh
* Run it using one of two modes:
    * If you have already packaged your project just do: ./start.sh
    * If you haven't already packaged your project you need build it during starting period by: ./start.sh -b
* After you have run script you should input the "search string" when it will be necessary and press enter.
* Then firefox will be run and you will see the list of page titles in console.

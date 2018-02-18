# SLOGO Architecture Design
1.  When does parsing need to take place and what does it need to start properly?
    * Parsing needs to take place whenever a user enters a command to move the turtle. 
    * In order for parsing to start, the user will likely have to press a button or hit enter on the keyboard. The command will then be passed to the parser and then to the backend. 

2.  What is the result of parsing and who receives it?
    * The result of parsing would be a call to a command in the backend.

3.  When are errors detected and how are they reported?
    * Error detection is dependent on class structure and design. Depending on the different categories of parsers (e.g. for Cell Society, we had a specific XML parser subclass extending the general XML parser superclass, which allowed each subclass simulation to implement its own error checking), we may choose to have errors detected in subclass implementations with the error being reported back to the parser (e.g. a setter method for error). Another design choice may be having a general class maintain error checking and reporting to the GUI, thus setting errors as appropriate.

4.  What do commands know, when do they know it, and how do they get it?
    * Commands know the string representing the instruction (e.g. fd for *forward*) and the integral or decimal value corresponding to the *amount* of that instruction (e.g. fd 50 means *move forward 50*). When the use presses enter, the translation of the command is processed by a parser/translator class, which then determines the respective movement of the turtle (with control transferred back to front-end GUI).

5.  How is the GUI updated after a command has completed execution?
    * The turtle, of whose instance is created in front-end, will have updated its fields/parameters/attributes to the translation provided by the parser for the executed command. After editing these characteristics, the front-end class(es) will *update* the turtle using a variety of specific methods (e.g. movement, direction changes, etc).


## APIs
### Front end 
#### Internal API
* getImage()
* drawTurtle()
* drawLine()
* update()

#### External API 

### Back end 
#### Internal API 
* forward(int x)
* back (int x)
* left (int x)
* right (int x)
* setHeading(int x)
* towards(int x, int y)
* setXY(int x, int y)
* penDown()
* penUp()
* showTurtle()
* home()
* clearScreen()
* xcor()
* ycor()
* heading()
* isPendown()
* isShowing()
* sum()
* difference()
* product()
* quotient()
* remainder()
* minus()
* random()
* sin()
* cos()
* tan()
* atan()
* log()
* pow()
* pi()
* less()
* greater()
* equal()
* notEqual()
* and()
* or()
* not()
* make/set()
* repeat()
* doTimes()
* for()
* if()
* ifElse
* to 

### External API 
* getLocation()
* getHeading()
* setX()
* setY()
* setHeading()
* getLocation()
* setShowing()
* turtleIsShown()
* setPenDown()
* getPenDown()
* getNextPoints()
* addNextPoint()
* getCommandLog()
* getCommands()
* saveNewCommand()
* execute()
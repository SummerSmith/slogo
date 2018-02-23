# SLOGO Design Plan

## Introduction (Summer)
In this project, we are creating a simplified programming language that individuals can use to move a turtle in a window. The program is going to flexible in the fact that it allows the user to save their own methods, keep track of variables, and view their command log. This will allow the user to develop more complex methods than those provided in the API. 

The program should be able to handle the user inputting multiple commands at one time, or using commands themselves as inputs to other commands, such as "forward forward 50".

We have three different areas to our program: the front end, the parser (acts as the translator between front and back end), and the back end. 
* The front end will be organized into several different classes that are aspects of the GUI and will be the only part of the program that interacts with the user. It will deal with background color, pen color, turtle image, language, etc. The front end is also where the turtle object will be created. 
    * The majority of the front end will be protected or private because the backend should never need to access information in the front end that is not passed through the parser. 
* The parser will take the user input in the command box and translate it into something that the back end of the program understands and can work with. 
* The backend will execute the commands inputted by the user and update the turtle object. The frontend will then show these changes. 
    * The only parts of the backend that are public are the methods involving the turtle as well as getters for the data structures that hold user defined variables, commands, and the user command log. The remaining aspects of the backend should be either private or protected. 
    

## Design Overview (Yameng)

### Backend
Our backend consists of a parser which parses the text input from frontend to commands that backend can understand. Other parts of the backend execute the command on Turtle, and store user-related information.

#### Backend External
In the **Parser** class, since the details about how to implement the parsing process will be discussed on Tuesday, we only discussed the general purpose of this class, which is taking in the text input (native language) to translate and output the commands (programming language) according to the specific language the user types in. So this class should at least include a public method which does the transition and can be called by the frontend.

The **Executor** class takes parser output and calls appropriate command. Manages return value and ensures all commands were executed (e.g. fd fd 50). So it needs public method to be called by **Parser** class to execute the command.

The **Turtle** class manages all turtle-related members and behaviors. Among all of them, public methods include **getLocation()**,**getHeading()**,**setX()**,**setY()**,**setHeading()**,**getLocation()**,**setShowing()**,**turtleIsShown()**,**setPenDown()**,**getPenDown()**,**getNextPoint()** and **addNextPoint()**. Those methods are directly called by other parts.

The **UserHistory** class should has public method **getCommandLog()** which can be called by **Executor** class. The **UserCommmand** class should include public method **getCommands()** and **addNewCommand()**. The **UserVariables** class should include public method getVariables().

The **Command** class is a super class which is inherited by **TurtleMovement**, **TurtleQueries**,**Operations**,**Booleans** and **ControlStructures** classes.The **Command** super class should have execute public method which deals with return value. According to the project specification, all methods in **TurtleMovement**, **TurtleQueries**, **Operations**,**Booleans** and **ControlStructures** classes are not public.

#### Backend Internal
In **Parser** class, the translation from user's typed texts to commands based on user's language should be internal.

The Execution part of the **Execution** class (e.g., decide which method to execute according to the input command) is internal.

All methods not listed in previous section in **Turtle** class should be internal.

The **UserHistory**, **UserCommand** and **UserVariables** class should has some internal methods that function to manage the logs.

According to the project specification, all methods in **TurtleMovement**, **TurtleQueries**, **Operations**,**Booleans** and **ControlStructures** classes are internal methods.

### Frontend
Frontend parts includes a display window, and all elements that are shown in the display window (e.g., TurtleWindow, CommandWindow, UserVariablesWindow, UserHistoryWindow and UserCommandsWindow). 

#### Frontend External
The **Display** class represents the main window of the program and is the enter point of the program. So it should includes public methods **start()** and **main()**.

The **WindowElements** class is an interface which contains methods for window elements, to be implemented in each of the window classes. The public methods include **addScrollBar()**, **createWindow()**, **getX()**,**setX()**,**getY()** and **setY()**. This interface is implemented by **TurtleWindow**, **CommandWindow**, **UserVariablesWindow**, **UserHistoryWindow** and**UserCommandsWindow** class.

The **Error** class creates a label with text assigned by parser class(es) for incorrect instruction(s). It contains public method which is called by **CommandWindow** and generates the error when the input commands is wrong.

#### Frontend Internal
The **Display** class includes public methods **createScene()**, **createStage()**,**createButton()**,**createComboBoxes()**, **createLabels()** and **addAll()**.

The **TurtleWindow** class sets up the window that has the turtle. It contains internal methods **getImage()**, **update()**, **drawLine()**, **getPenColor()**, **setPenColor()** and **drawTurtle()**.

The **CommandWindow** class sets up the box where user types in commands. The private method in this class is **sendInstructionToParser()**.

The **UserVariablesWindow** class sets up the box that can display a data structure as a list of user variable texts. Private methods are **getVariables()** and **updateGui()**.

The **UserHistoryWindow** class sets up the box that can display a data structure as a list of user history instruction texts. Private methods are **getHistory()** and **updateGui()**.

The **UserCommandsWindow** class sets up the bos that can display a data structure as a list of user-created command texts. Private methods are **getUserDefinedCommands()** and **updateGui()**.

The **Error** class includes private method **addError()**.

## User Interface (Aditya)

The user interacts with the program by typing in commands into the command window (managed by the **CommandWindow()** class). A visual layout of the SLogo application can be viewed in ![SLogo Diagram](/images/SLogoDiagram.png). As shown in the picture, the GUI consists of a command window, turtle window (displaying turtle and turtle movement), windows to display user data (i.e. user-defined variables, user-defined commands, and user history). When the user defines a *variable*, the variable will be added to both the user's history and the user's defined variables. When the user defines a *command* or *method*, the same will happen for the user-defined commands/methods window.

The user interface also consists of a series of buttons that allow the user to execute, enhance, or modify certain features. The *run* button will execute the command typed in by the user, which is then communicated to the parser. When the necessary information is passed back to the GUI, the turtle's properties and state will be modified visually in the turtle window to allow users to view the effects of their entered command or method. When the *clear* button is pressed, the command window resets. When the *save method* button is pressed, the method is saved and is added to the user-defined methods window for later use and for code simplification. Another button is the "command reference page (API)," which will allow the user to view/reference commands in a separate window.

The user interface consists of comboboxes to allow different selections for the user to choose from. *Pen color* allows the user to set the pen color for the line drawn by the turtle when it moves. *Background color* assigns the turtle window background a user-specified color. *Turtle image* allows the user to choose another image for the turtle from a list of different image options. Finally, *language* will allow the user to set the language of all commands and text. All entered commands written in the respective language will be handled during parsing, but this capability allows for a language-friendly environment.

Finally, in the case that commands entered by the user or incorrect or erroneous, a label will appear above the command window specifying the type of error and reason for why the commands failed to execute. The actual texts that will be passed into the GUI form the parser will be determined through parsing, but possible erroneous situations that the user will be aware of include: bad input data, empty data, command does not exist, etc.


## API Details (Maddie)

Our design can be represented in some ways as a Model-View-Controller framework, with the frontend classes comprising the View, the Parser class comprising the Controller, and the backend classes comprising the Model.
### Frontend

```
code
```

#### External


#### Internal

### Backend

#### External

#### Internal



## API Example Code (Maddie)

## Design Considerations (Summer)
One major unknown with the current design is how the parser is going to work. We are unsure how it is going to handle input from the user, what type of object it will return, and how much work it will do. Since there are still a lot of questions about this part of the program, it is hard to know for sure how some other classes are going to work, such as the Executer class. The idea behind this class is that it will take the ouput from the parser and execute the users commands, keeping track of the return values and add points to the turtles array of next points to move to. Once the details of this section are flushed out, we will be able to have more in-depth conversations about how information will get from the parser to the command classes. 

One aspect of the program that we discussed in depth is how information will be passed from one part of the program to another. We decided that any information being passed to the backend will have to go through the parser. This will keep the program clean with well-defined paths in which information can travel. Information will get from the back-end to the front-end via the turtle class. The front-end will be able to access the private instance variables in the turtle class through getters and setters. It will then use this information to update the turtle display. User commands, variables, and history will be stored and updated in the backend and displayed by the front end. 

One dependency of this design is the assumption that the Executer class will be able to handle multiple instructions passed in at one time. Since there are unknowns about the parser, the specifics of this functionality have not yet been discussed and need to be fleshed out before coding begins on this class. 

We are using inheritence to create all the command classes in the backend. The argument for doing this is that an instance of a command class can be created without knowing which class the specific command is in. However, we are unsure about what methods will go in the superclass. It is likely that there may be a method all the children class use to handle the return values and pass them back to the Executer class, but this could also be handled by the Executer class itself. As code begins to be written, this aspect of the program will hopefully become clearer. 

## Team Responsibilities (All)
Summer: helping with back end and front end
Maddie: mostly backend, help w/frontend when needed
Aditya: mostly front end, helping with back-end when needed 
Yameng: mostly backend, helping with frontend
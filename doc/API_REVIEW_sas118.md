# API Review

### Part 1
1.  What about your API/design is intended to be flexible?
    * Our design is intended to be flexible in the fact that if new commands are added, only the property files will need to be edited. Nothing within the parser will need to change. 
    * In addition, if commands that take more than one or two arguments are added, the implementation will be able to handle that easily. 
     
2.  How is your API/design encapsulating your implementation decisions?
    * Our parser should not directly access the GUI but will be passed everything through the front end. 
    * In addition, the parser will store the commands privately and will only call methods in the back end when needed. 
    
3.  What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?
    * There are several errors that might occur in the parser. Some of these include invalid syntax in the string typed in by the user, invalid number of arguments, and invalid command. 
    * The parser will throw an error back to the front end, where an error message will be displayed to the user. 
    * The goal is to make this message specific to the problem. 
    
4.  Why do you think your API/design is _good_ (also define what your measure of good is)?
    * I think the design is good because it spreads out the responsibilities of the parser between multiple classes. There will not be one class that contains all the code.
    * In addition, the code is very flexible and should not have to be changed if other commands are added or a different number of commands is expected. 
    
    
### Part 2
1.  How do you think Design Patterns are currently represented in the design or could be used to help improve the design?
    * Currently we are using a version of the strategy design plan or the command design plan for the backend. The Executor class will have information that the commands in the child classes will access and edit, based on their functionality. 

2.  What feature/design problem are you most excited to work on?
    * I am most excited to figure out the stack/tree and argument array process. I want to ensure that it will catch a command that has the wrong number of arguments or that has incorrect commands included.

3.  What feature/design problem are you most worried about working on?
    * I am most worried about catching mistakes in which there are the wrong number of arguments or where 15 is represented as ( 10 + 5 ). I think these cases will be the hardest to catch and properly execute. 

4.  Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams).
    * sum fd 50 rt 90
    * fd fd 50 
    * fd 50 
    * sum rt 90 fd 50 
    * difference rt 45 fd 10
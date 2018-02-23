# API Review

### Part 1
1.  What about your API/design is intended to be flexible?
    * Our design is intended to be flexible in the fact that if new commands are added, only the property files will need to be edited. Nothing within the parser will need to change. 
    * In addition, if commands that take more than one or two arguments are added, the implementation will be able to handle that easily. 
     
2.  How is your API/design encapsulating your implementation decisions?
    * Our parser should not directly access the GUI but will be passed everything through the front end. 
    * In addition, the parser will store the commands privately and will only call methods in the back end when needed. 
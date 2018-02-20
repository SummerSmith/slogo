# API Critique

## Simulation
Classes: Cell, AntCell, ConwayCell, FireCell, RPSCell, HexagonCell, SegregationCell, WaterCell, Simulation, ForagingAnts, GameOfLife, RPS, Segregation, SpreadingOfFire, WaTor

#### Internal  
* Classes: 
    * AntCell
    * ConwayCell
    * FireCell
    * RPSCell
    * HexagonCell
    * SegregationCell
    * WaterCell
    
Since the cell classes are in their own package, and the simulations are located within their own package, it requires more methods to be public. If all classes involving one simulation were in the same package, a lot more of the listed methods would be able to be protected or private, rather than public. 
If the classes were organized in this way, there could be one copy of the public grid located in the simulation class. This grid would be used by the frontend to display the simulation. This would enable the program to have fewer public methods. 

#### External
* Classes: 
    * Cell
    * Simulation
    * ForagingAnts
    * GameOfLife
    * RPS
    * Segregation
    * SpreadingOfFire
    * WaTor

The methods in these classes likely have to be accessed by the front end code and possibly the XML parser. This is how the frontend is going to display the simulation.
The public methods 
Not all of the methods in the simulation subclasses need to be public, but it is likely that some of them will be. In addition, not all of the super class methods need to be public. However, it is more likely that other parts of the program will need to reference methods in these classes than in classes listed in the internal section. 

## Configuration
Classes: XMLParser, WatorParser, SegregationParser, RPSParser, FireParser, ConwayParser, AntParser
#### Internal
For the internal API, several methods within each of the XML parser subclasses would be classified as internal. For example, it would be easier for future coders within the module to extend methods like getSharkStartingEnergy()*. In effect, other shark characteristics within the WatorParser class specific to the Shark object.    
    
#### External
In RPSParser, getProbRock(), getProbPaper() and getProbScissors() should be external, because outside module such simulation needs this. 

In FireParser, getProbCatch() should be external, and reason is the same as in RPSParser.

In SegregationParser, I think other modules needs to access the percentage of blue and red, so getBluePercentage() and getRedPerentage() should be external. 

In WatorParser, other modules needs to access the getMaxChrononCount(), getSharkStartingEnergy(), and getFishEnergy(), so those methods should be external. 

Other external API methods include those for error checking, which is used by each of the subclass simulations. The *setError()* method in the XML parser superclass, for example, would be implemented in each of the subclasses to facilitate error checking in specific simulations.


## Visualization
Classes: ChooseSimulation, MainMenu, Buttons, ComboBoxes, Labels, StateBar

#### Internal
Currently, the ChooseSimulation and MainMenu classes are located within the cellsociety_team12 package, and the Buttons, ComboBoxes, Labels, and StateBar classes are located within the elements package. I'm assuming that the StateBar uses Buttons, ComboBoxes and Labels to create a portion of the user interface, and in this case I think that the all of methods in the latter three classes should be protected (not public as they are currently), and part of the internal API. I am also assuming that the MainMenu class uses StateBars to display the UI, and depending on how this is implemented it may need to use methods from StateBar.  

#### External
For the most part, I think that the API of the visualization classes should be internal, because other components of the project should not depend on the visualization component. However, if methods from ChooseSimulation are used in creating Buttons, Labels, and other UI components, I think that it is acceptable to have some public methods available to these classes.
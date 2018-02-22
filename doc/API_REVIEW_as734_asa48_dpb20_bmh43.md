# SLogo API Review

## Part 1
1. The design is intended to be flexible: flexibility in transitioning, keeping methods as simple as possible, etc. We discussed how simple will it be to add new features to the application (e.g. add methods to the API, create GUI elements, etc).
2. Inheritance, abstract classes/methods, and interfacing facilitate implementation decision-making when mapping to API design. The API should be comprehensive and should contain everything the user can access without causing issues on the developer end.
3. There could be different types of errors, with functionality managed by the back-end. The front-end will have limited functionality (part of external API) that will contain some error object. The string representing the error will processed in and returned by the back-end to the front-end, and the front-end will print that error string to the GUI through a label.
4. For now, the design is adequate. The internal front-end is better than the external front-end, with room for flexibility (e.g. interaction among the components through inheritance relationships). We will be making modifications to our design along the way as we increase the complexity of the application and add more advanced features.

## Part 2
1. The design pattern for the front-end we decided to choose is the "Mediator" design pattern - this will allow us to transition between front-end and each of back-end and parser. As we progress through the SLogo project, in terms of front-end, we will be making modifications in the form of improvements and pattern additions. Some design patterns (e.g. Factory patterns) might be more useful across both front-end and back-end. Overall, they can improve the design by increasing flexibility and create independence/atomicity for functionality of different SLogo application components.
2. We are most excited about displaying the languages on-screen to see how the application displays the output of parser translation.
3. We are most worried about the mediator, integrating the front-end with the back-end and parser. This might require additional brainstorming and implementation to increase functionality.
4. Five use cases for the front-end include: a) change background color; b) change turtle image; c) change pen color; d) get last command in command window with up arrow, and; e) change the language.
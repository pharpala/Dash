# Dash

## Project Description

Welcome to Dash, a Java-based game developed using JavaFX libraries. Dash offers a straightforward yet engaging gaming experience where players navigate obstacles, collect coins to boost their score, and strive to surpass their personal best. The game's intuitive design ensures an enjoyable experience for players of all skill levels.

## Gameplay/Scenes

### Title Screen

Upon launching the game or restarting after a session, you'll be greeted by the **title screen**. Here, you can explore controls, view the current local high score, and prepare for the exciting gaming adventure!

![Title Screen Image](https://raw.githubusercontent.com/pharpala/Dash/master/samples/titleScreen.png "Sample Title Screen")

### Character Select Screen

Customize your experience by entering your name and selecting a character from three unique styles. Your chosen name is associated with your score, adding a personal touch to your Dash journey.

![Character Select Image](https://raw.githubusercontent.com/pharpala/Dash/master/samples/characterSelectScreen.png "Sample Character Select Screen")

### Gameplay

Experience Dash through dynamic gameplay. The game starts at an easy pace, progressively accelerating as your score increases. The maximum speed is at 40 points, only the best survive till then!

![Gameplay Sample](https://raw.githubusercontent.com/pharpala/Dash/master/samples/gameplaySample.gif "End Screen Sample")

### End Screen

When your adventure ends, the end screen provides options to play again or exit the game. See your performance and decide whether you have another round in you.

![End Screen Image](https://raw.githubusercontent.com/pharpala/Dash/master/samples/endScreen.png "End Screen Sample")

## Project Specifications

* Developed and tested using [JavaFX SDK 18.0.2 libraries](https://gluonhq.com/products/javafx/).
* Used [JDK version 18.0.2.1](https://www.oracle.com/java/technologies/downloads/) during production and testing.

## Download

## Operating System

Windows download: [Dash.zip](https://raw.githubusercontent.com/pharpala/Dash/master/downloads/Dash-v1.0.zip) \

## Downloading Steps

1. Download the [JDK version 18.0.2.1](https://www.oracle.com/java/technologies/downloads/). Skip this if you already have it
2. Download the zip file according to your operating system.
3. Extract the zip file to a location of your choosing.
4. Open the run.bat file that is in Dash folder that you extracted. Windows Defender might step in here saying the file is not trustworthy. In this case, click "More Info" and click "Run anyway" (I promise I´m not an hacker).

At this point the game should run and you can play away!

## Troubleshooting

## Issues with Java handling `.jar` files

If you see that the `Dash.jar` file is not being opened with by Java (it is in the extracted folder from the `.zip`), you must change the app that `.jar` files are opened with. On your system, you might see the `.jar` file with a WinRAR icon or some other app. First, make sure you have done the first step shown in the Downloading Steps.

To Fix this issue (Windows):

1. Open up your Settings
2. Apps (Left Side)
3. Default Apps
4. Scroll all the way down to "Choose defaults by file type" under "Related settings"
5. Type in `.jar` into the search bar
6. Change the app to Java(TM) Platform SE binary (the java app that pops up)

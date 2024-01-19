# Dash

## Project Description

This is a basic game I created using Java, specifically using JavaFX libraries. It's a simple game where you must dodge the obstacles and collect coins to increase your score. The game keeps track of your highscore, so you can keep playing until you beat your personal best!

## Gameplay/Scenes

This is the **title screen**, this is the screen that it brings you to when you first run the game and play again after you die. You can also check the controls and current high score (local):

![Title Screen Image](https://raw.githubusercontent.com/pharpala/Dash/master/samples/titleScreen.png "Sample Title Screen")

This is the **character select screen**, this is where you enter your name and select your character. The character do not have anything unique about them besides then having their own styles! You also must enter your name here, this name cannot be blank and cannot contain a "=". This is the name that is associated with your score.

![Character Select Image](https://raw.githubusercontent.com/pharpala/Dash/master/samples/characterSelectScreen.png "Sample Character Select Screen")

This is sample **gameplay**. It starts off slower than it shows in this gif, with the speed increasing as your score goes up. The speed reaches it's max at 40 score (this gif shows the max speed):

![Gameplay Sample](https://raw.githubusercontent.com/pharpala/Dash/master/samples/gameplaySample.gif "End Screen Sample")

Finally, this is the **end screen** when you die in the game. You can either play again or exit the game:

![End Screen Image](https://raw.githubusercontent.com/pharpala/Dash/master/samples/endScreen.png "End Screen Sample")

## Project Specifications

* This project was created and tested using [JavaFX SDK 18.0.2 libraries](https://gluonhq.com/products/javafx/).
* The JDK used during production and testing was [JDK version 18.0.2.1](https://www.oracle.com/java/technologies/downloads/).

# Download

## Operating System

Windows download: [Dash.zip](https://raw.githubusercontent.com/pharpala/Dash/master/downloads/Dashv1.0.zip) \

## Downloading Steps

1. Download the [JDK version 18.0.2.1](https://www.oracle.com/java/technologies/downloads/). Skip this if you already have it
2. Download the zip file according to your operating system.
3. Extract the zip file to a location of your choosing.
4. Open the run.bat file that is in Dash folder that you extracted. Windows Defender might step in here saying the file is not trustworthy. In this case, click "More Info" and click "Run anyway" (You can trust me).

At this point the game should run and you can play away!

# Troubleshooting

## Java is not dealing with your `.jar` files

If you see that the `Dash.jar` file is not being opened with by Java (it is in the extracted folder from the `.zip`), you must change the app that `.jar` files are opened with. On your system, you might see the `.jar` file with a WinRAR icon or some other app. First, make sure you have done the first step shown in the Downloading Steps.

To Fix this issue (Windows):

1. Open up your Settings
2. Apps (Left Side)
3. Default Apps
4. Scroll all the way down to "Choose defaults by file type" under "Related settings"
5. Type in `.jar` into the search bar
6. Change the app to Java(TM) Platform SE binary (the java app that pops up)

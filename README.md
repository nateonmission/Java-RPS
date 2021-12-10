# Rock Paper Scissors
*This page uses vanilla Java to implement a Rock Paper Scissor game.*

## Basic Information
- Two players can play as many games as they wish and the app will track the number of games won by each player.
- One player can play against the computer.
- If players elect not to play another game, the Main Menu is returned.
- The game tacks each round and write it to a history file.
- On exit, the match stats are also written to the file.

## Design Approach
My aim is to build this game app in an Object Oriented way. Currently, each player is represented by a Player object. The computer makes its move through a method called on its object. Game mechanics and stats are held the Game object.

## Installation
Open the project in a Java IDE like IntelliJ, and it should build with Java 12.

## Picking a Winner
RPS is really simple. Therefore, I just used nested IF statements

## The Automated Player
The game just picks a random move from an array.

## Things to Do in the Future
- History currently just opens in notepad. I'll move this to an internal implementation.
# rain-and-drops

[![TravisCI](https://travis-ci.org/SnapGames/rain-and-drops.svg?branch=develop)](https://travis-ci.org/SnapGames/rain-and-drops "open the TravisCI compilation trend") [![Dependency Status](https://www.versioneye.com/user/projects/59d22ffc0fb24f00420314b1/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/59d22ffc0fb24f00420314b1 "Open on VersionEye")

## Game Development Java Basics prototypes/rain-and-drops

This project is part of the [GDJ](https://classroom.google.com/c/NzI2ODQ3NjU2MFpa/t/NzI2Nzg0MjgxNFpa) course from [GameDev Basics
Java](https://classroom.google.com/c/NzI2ODQ3NjU2MFpa "Open the official on-line course") 
provided by the [SnapGames](http://snapgames.fr) site. 

### Goal

TODO

## Compile

To compile the full project, please execute the following command :

```bash
$> mvn clean install
```

## Execute

to execute the the compiled jar, please execute the command bellow :

```bash
$> mvn exec:java
```

or :

```bash
$> java -jar rain-and-drops-0.0.1-SNAPSHOT.jar
```

## Edit

Import this project as an Existing Maven Project into your prefered IDE, 
(like [Eclipse](http://www.eclipse.org/downloads "open the eclipse official web download page") ?)


## Some screen shots ?

TODO
 
### Play State

The `PlayState` is only a capabilities demonstration purpose state.

![PlayState with minimum debug info](src/main/docs/images/screenshot%2081542505497219.jpg "PlayState with minimum debug info") ![PlayState without any debug info](src/main/docs/images/screenshot%2081547820149296.jpg "PlayState without any debug info");

Use the following keys:

- <kbd>D</kbd> / <kbd>F9</kbd> switch between DEBUG modes (see previous table)
    
- <kbd>H</kbd> display a help panel to show keyboard shortcuts :)    
- <kbd>UP</kbd> / <kbd>DOWN</kbd> / <kbd>LEFT</kbd> / <kbd>RIGHT</kbd> to move the blue square which is the `Player` game object,
- <kbd>SHIFT</kbd> / <kbd>CTRL</kbd> with  cursor key will accelerate move,
- <kbd>PG-UP</kbd> / <kbd>PG-DOWN</kbd> will increase decrease number of `Enemy` and `Eatable` game objects (to raise-up your energy), 
- <kbd>SHIFT</kbd> / <kbd>CTRL</kbd> with <kbd>PG-UP</kbd> and <kbd>PG-DOWN</kbd> keys will accelerate increasing.

Have Fun !

Send a mail to [SnapGames](mailto:contact@snapgames.fr?subject=rain-and-drops "send a mail to your tutor")

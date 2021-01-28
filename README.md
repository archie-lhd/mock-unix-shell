# mock-unix-shell

## Overview

This is a group course project for CSCB07 at UTSC in 2020 Fall. 

Just like what Unix Shell does, the program can take in and parse the user input (command lines), then run the command as expected.

<img width="411" alt="Screen Shot 2021-01-28 at 6 19 51 AM" src="https://user-images.githubusercontent.com/77775845/106131600-e39d6680-6130-11eb-8e5b-3ee1acd2772d.png">

## Instructions

To run the program, build and run `driver/JShell.java`.

## Supported Commands

- rm DIR
- mkdir DIR ...
- cd DIR
- ls [-R][PATH ...]
- pwd
- mv OLDPATH NEWPATH
- cp OLDPATH NEWPATH
- cat FILE
- curl URL
- echo String
- man CMD
- pushd DIR
- popd
- history [NUMBER]
- saveJShell FileName
- loadJShell FileName
- search path ... -type [f|d] -name expression
- tree

For detailed descriptions of each command, you can either:
check `commands-descriptions.pdf` in the repository ***OR*** run the "man COMMAND" command in the mock shell.

## Contributors
- Archie Liu
- Leo Yu
- Ivan Shen
- Charlie Zhu


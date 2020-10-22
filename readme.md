# The Comically Large Spoon
only a spoonful

![the SPOON](spoon-large.png)

# Why?
i thought it would be funny

# Building

### Requirements
- Java 8 JDK
- Minecraft, probably.
- Hope

### Linux
*(Tested on Gentoo, Arch Linux, and Ubuntu.)*
1. Install all the necessary tools. *(git, java, etc. You should already know how to do this for your distro, so I wont 
get into it.)*
2. `git clone https://gitlab.com/jvyden/comicallylarge.git/` 
3. `./gradlew buildDependents`
4. While you wait, please perform a ritual to the gradle gods.

Your jar should be in `build/libs`. If an error occured, please repeat step 3-4 about 4-5 times. If it still doesn't work,
please submit an issue.

### Windows

I don't use windows, so I wouldn't know. If you successfully build on windows, let me know how.
I would imagine it's the same as the above linux directions.

## Contributing
1. Follow the current code style as closely as possible. Try not to worry too much, I will point something out if you do it wrong.
2. Commit your code. If it's for a specific feature, please encapsulate it in brackets at the beginning of the commit
message, like so:

    `[Textures] Changed one insignificant pixel for absolutely no reason.`

4. Be patient.

    CI will take up to 10 minutes to check and build your code. If the build fails, please fix your code and try pushing again.
    The testing system is new, and still being tweaked, so if a warning seems unreasonable let us know.
    
    Of course, human review is also necessary to progress. It should take a few hours up to a few days to get a response.
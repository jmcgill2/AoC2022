package jmcgill2.aoc2022.day7

class Day7Question2 {

    String fileLocation = "//Users//jimmcgill//AdventOfCode2022//Day7//input.txt"

    Directory rootDirectory

    Directory currentDirectory

    ArrayList<Directory> allDirectories = []

    int totalCapacity = 70000000

    int totalFreeSpace = 30000000

    static void main(String[] args) {
        Day7Question2 q2 = new Day7Question2()
        q2.run()
    }

    public void run() {

        int totalSize
        File file = new File(fileLocation)
        Directory directory
        file.eachLine {line ->
//            println line
            if (line.startsWith("\$ cd")){
                if (line.startsWith("\$ cd ..")){
                    directory = currentDirectory.previousDirectory
                    currentDirectory = directory
                }else {
                    String directoryName = line.split(" ")[-1]
                    directory = new Directory(directoryName)
                    allDirectories << directory
                    if (rootDirectory == null) {
                        rootDirectory = directory
                        currentDirectory = directory
                        rootDirectory.previousDirectory = directory
                    } else {
                        directory.previousDirectory = currentDirectory
                        currentDirectory.lowerDirectories << directory
                        currentDirectory = directory
                    }
                }
            }else if (line[0].isNumber()){
                int fileSize = line.split(" ")[0].toInteger().intValue()
                String fileName = line.split(" ")[1]
                currentDirectory.files << new DirectoryFile(fileName, fileSize)
                totalSize += fileSize
            }
        }
        def rootSize = rootDirectory.calculateDirectorySize()
        println "root directory size is ${rootDirectory.calculateDirectorySize()}"
        def availableSpace = totalCapacity - rootSize
        def missingSpace = totalFreeSpace - availableSpace
        println "missingSpace = " + missingSpace
        println "availableSpace = " + availableSpace
        //println directory + " - " + totalSize
        println "totalSize = $totalSize"
        def finals = []
        int currentDirectorySize = totalSize
        String currentDirectoryName
        allDirectories.each{dir ->
            def size = dir.calculateDirectorySize()
            if (size >= missingSpace){
                finals << [name:dir.directoryName, size:size]
                if (size < currentDirectorySize){
                    currentDirectorySize = size
                    currentDirectoryName = dir.directoryName
                }
            }
        }

        println currentDirectoryName + " " + currentDirectorySize

    }
}

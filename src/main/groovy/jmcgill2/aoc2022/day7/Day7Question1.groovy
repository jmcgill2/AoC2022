package jmcgill2.aoc2022.day7

class Day7Question1 {

    String fileLocation = "//Users//jimmcgill//AdventOfCode2022//Day7//input.txt"

    Directory rootDirectory

    Directory currentDirectory

    ArrayList<Directory> allDirectories = []

    static void main(String[] args) {
        Day7Question1 q1 = new Day7Question1()
        q1.run()
    }

    public void run() {

        int totalSize
        File file = new File(fileLocation)
        Directory directory
        file.eachLine {line ->
            println line
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
        println "root directory size is ${rootDirectory.calculateDirectorySize()}"
        //println directory + " - " + totalSize
        println "totalSize = $totalSize"
        def finals = []
        allDirectories.each{dir ->
            def size = dir.calculateDirectorySize()
            if (size <= 100000){
                finals << [name:dir.directoryName, size:size]
            }
        }

        println "finals = $finals"
        println "size = ${finals.sum{it.size}}"
    }
}

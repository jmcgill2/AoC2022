package jmcgill2.aoc2022.day7

class Day7Question1 {

    String fileLocation = "//Users//jimmcgill//AdventOfCode2022//Day7//input.txt"

    Directory directory

    static void main(String[] args) {
        Day7Question1 q1 = new Day7Question1()
        q1.run()
    }

    public void run() {
        Directory currentDirectory

        int totalSize
        File file = new File(fileLocation)
        file.eachLine {line ->
            println line
            if (line.startsWith("\$ cd") && !(line.startsWith("\$ cd ."))){
                //println directory + " - " + totalSize
                String directoryName = line.split(" ")[-1]
                currentDirectory = new Directory("directoryName")
                if (directory == null){
                    directory = currentDirectory
                } else {
                    directory.lowerDirectories << currentDirectory
                }

            }else if (line[0].isNumber()){
                totalSize += line.split(" ")[0].toInteger().intValue()
            }
        }
        //println directory + " - " + totalSize
    }
}

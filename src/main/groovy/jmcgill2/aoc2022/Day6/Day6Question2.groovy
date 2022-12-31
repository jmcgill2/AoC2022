package jmcgill2.aoc2022.Day6

class Day6Question2 {
    String fileLocation = "//Users//jimmcgill//AdventOfCode2022//Day6//input.txt"

    static void main(String[] args) {
        Day6Question2 q1 = new Day6Question2()
        q1.run()
    }

    public void run(){
        ArrayList lines = readLines()

        ArrayList locations = []
        lines.each{line ->
            locations << findLocation(line)
        }
        println locations
    }

    def findLocation(line){
        ArrayList letters = line.split("")
        def notFound = true
        int position = 14
        int start = 0
        int finish = 13
        while(notFound){
            if (letters[start..finish].unique().size() == 14){
                notFound = false
            }else {
                start++
                finish++
                position++
            }
        }
        return position
    }

    ArrayList readLines(){
        File file = new File(fileLocation)
        ArrayList lines = []
        file.eachLine{line ->
            lines << line
        }
        return lines
    }
}

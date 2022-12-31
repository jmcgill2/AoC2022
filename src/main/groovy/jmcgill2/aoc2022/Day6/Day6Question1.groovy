package jmcgill2.aoc2022.Day6

class Day6Question1 {
    String fileLocation = "//Users//jimmcgill//AdventOfCode2022//Day6//input.txt"

    static void main(String[] args) {
        Day6Question1 q1 = new Day6Question1()
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
        int position = 4
        int start = 0
        int finish = 3
        while(notFound){
            if (letters[start..finish].unique().size() == 4){
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

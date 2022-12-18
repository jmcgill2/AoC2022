package jmcgill2.aoc2022.Day4

class Day4Question1 {
    String fileLocation = "//Users//jimmcgill//AdventOfCode2022//Day4//input.txt"

    static void main(String[] args) {
        Day4Question1 q1 = new Day4Question1()
        q1.run()
    }

    public void run(){
        File file = new File(fileLocation)
        int total = 0
        file.eachLine{line ->
            def tmp = line.split(",")
            def firstRange = tmp[0].split("-")
            def secondRange = tmp[1].split("-")
            if (checkRange(firstRange, secondRange)){
                total++
                println "Match $firstRange and $secondRange"
            }else if (checkRange(secondRange, firstRange)){
                total++
                println "Match $line"
            }
        }
        println "total = $total"
    }

    public boolean checkRange(testRange, baseRange){
        return (testRange[0].toInteger() >= baseRange[0].toInteger() && testRange[1].toInteger() <= baseRange[1].toInteger())
    }
}

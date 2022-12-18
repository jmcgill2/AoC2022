package jmcgill2.aoc2022.day1
/**
 * Read an input file that contains either a single integer value or nothing on a line.
 * Add up all the integers that are separated by a blank line.
 * Print the largest number.
 */
class Question1 {
    static void main(String[] args) {
        Question1 q1 = new Question1()
        q1.run()
    }

    def run() {
        def maxCal = calcLargestNumber()
        println maxCal
    }

    def calcLargestNumber(){
        def maxCal = 0
        def currentCal = 0
        File file = new File("//Users//jimmcgill//AdventOfCode2022//Day1//input.txt")
        file.eachLine{line ->
            if (line == ""){
                if (currentCal > maxCal){
                    maxCal = currentCal
                }
                currentCal = 0
            } else {
                currentCal += line.toInteger().intValue()
            }
        }

        return maxCal
    }
}

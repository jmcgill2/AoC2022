package jmcgill2.aoc2022.day1

class Question2 {
    static void main(String[] args) {
        Question2 q2 = new Question2()
        q2.run()
    }

    def run() {
        def cals = calcLargestNumber()
        println sumCals(3, cals)
    }

    def sumCals(int num, cals){
        def totalCals = 0
        for (x in 0..(num-1)){
            totalCals += cals[x]
        }
        return totalCals
    }

    def calcLargestNumber(){
        def currentCal = 0
        def cals = []
        File file = new File("//Users//jimmcgill//AdventOfCode2022//Day1//input.txt")
        file.eachLine{line ->
            if (line == ""){
                cals << currentCal
                currentCal = 0
            } else {
                currentCal += line.toInteger().intValue()
            }
        }

        return cals.sort().reverse()
    }
}

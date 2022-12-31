package jmcgill2.aoc2022.Day5

class Day5Question2 {

    String fileLocation = "//Users//jimmcgill//AdventOfCode2022//Day5//input.txt"

    ArrayList lines = []

    ArrayList stacks = [["P", "D", "Q", "R", "V", "B", "H", "F"],
                        ["V", "W", "Q", "Z", "D", "L"],
                        ["C", "P", "R", "G", "Q", "Z", "L", "H"],
                        ["B", "V", "J", "F", "H", "D", "R"],
                        ["C", "L", "W", "Z"],
                        ["M", "V", "G", "T", "N", "P", "R", "J"],
                        ["S", "B", "M", "V", "L", "R", "J"],
                        ["J", "P", "D"],
                        ["V", "W", "N", "C", "D"]]

    int numberOfCrates
    int originalStack
    int newStack

    static void main(String[] args) {
        Day5Question2 q2 = new Day5Question2()
        q2.run()
    }

    public void run() {
        File file = new File(fileLocation)
        file.eachLine{line ->
            if (line.startsWith("move")){
                lines << line
            }
        }
        lines.each{line ->
            def vals = line.split(" ")
            numberOfCrates = vals[1].toInteger().intValue()
            originalStack = vals[3].toInteger().intValue() - 1
            newStack = vals[5].toInteger().intValue() -1

            println "$numberOfCrates $originalStack $newStack"
            ArrayList crates = []
            for (x in 1..numberOfCrates){
                crates << stacks[originalStack].pop()
            }
            crates = crates.reverse()
            crates.each{crate ->
                stacks[newStack].push(crate)
            }
        }
        stacks.each{print it[0]}
        println ""
        println stacks
    }
}

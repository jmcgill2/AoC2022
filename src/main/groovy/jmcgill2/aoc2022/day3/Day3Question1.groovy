package jmcgill2.aoc2022.day3

class Day3Question1 {

    String fileLocation = "//Users//jimmcgill//AdventOfCode2022//Day3//input.txt"

    def priorities = ["A":27, "B":28, "C":29, "D":30, "E":31, "F":32, "G":33, "H":34, "I":35, "J":36, "K":37, "L":38, "M":39,
                "N":40, "O":41, "P":42, "Q":43, "R":44, "S":45, "T":46, "U":47, "V":48, "W":49, "X":50, "Y":51, "Z":52,
                "a":1, "b":2, "c":3, "d":4, "e":5, "f":6, "g":7, "h":8, "i":9, "j":10, "k":11, "l":12, "m":13, "n":14,
                "o":15, "p":16, "q":17, "r":18, "s":19, "t":20, "u":21, "v":22, "w":23, "x":24, "y":25, "z":26]

    static void main(String[] args) {
        Day3Question1 q1 = new Day3Question1()
        q1.run()
    }

    public void run() {
        File file = new File(fileLocation)
        int sumOfPriorities = 0
        file.eachLine{line ->
            def midpoint = line.size()/2
            def firstEndpoint = midpoint - 1
            ArrayList firstCompartment = line.substring(0, midpoint.toInteger()).split("").toUnique().sort()
            ArrayList secondCompartment = line.substring(midpoint.toInteger()).split("").toUnique().sort()
            ArrayList both =  firstCompartment.intersect(secondCompartment)
            //println both + " " + priorities.get(both[0]) + " " + line + " " + line.size() + " " + line.substring(0, firstEndpoint.toInteger()) + " " + line.substring(midpoint.toInteger())

            both.each{e ->
                sumOfPriorities += priorities.get(e)
            }
        }

        println sumOfPriorities
    }

}

package jmcgill2.aoc2022.day3

class Day3Question2 {

    String fileLocation = "//Users//jimmcgill//AdventOfCode2022//Day3//input.txt"

    def priorities = ["A":27, "B":28, "C":29, "D":30, "E":31, "F":32, "G":33, "H":34, "I":35, "J":36, "K":37, "L":38, "M":39,
                      "N":40, "O":41, "P":42, "Q":43, "R":44, "S":45, "T":46, "U":47, "V":48, "W":49, "X":50, "Y":51, "Z":52,
                      "a":1, "b":2, "c":3, "d":4, "e":5, "f":6, "g":7, "h":8, "i":9, "j":10, "k":11, "l":12, "m":13, "n":14,
                      "o":15, "p":16, "q":17, "r":18, "s":19, "t":20, "u":21, "v":22, "w":23, "x":24, "y":25, "z":26]

    static void main(String[] args) {
        Day3Question2 q2 = new Day3Question2()
        q2.run()
    }

    public void run() {
        int count = 1
        def lines = readFile()
        ArrayList line1
        ArrayList line2
        ArrayList line3
        int total = 0
        lines.each{line ->
            switch(count){
                case 1:
                    line1 = line.split("").sort()
                    count++
                    break
                case 2:
                    line2 = line.split("").sort()
                    count++
                    break
                case 3:
                    line3 = line.split("").sort()
                    def val = line3.intersect(line1.intersect(line2))
                    println "val = $val"
                    val.unique().each{
                        total += priorities.get(it)
                    }
                    count = 1
                    break
            }
        }
        println total
    }

    def readFile(){
        def lines = []
        File file = new File(fileLocation)
        file.eachLine{
            lines << it
        }
        return lines
    }
}

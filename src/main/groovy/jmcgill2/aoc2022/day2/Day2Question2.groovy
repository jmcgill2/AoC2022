package jmcgill2.aoc2022.day2

/**
 * Rock, Paper, Scissors simulator.  Points are as follows:
 * 0 for a loss
 * 3 for a draw
 * 6 for a win
 *
 * 1 for Rock (A)
 * 2 for Paper (B)
 * 3 for Scissors (C)
 *
 * Instruction to Player2
 * X is to Lose
 * Y is to Tie
 * Z is to Win
 */

class Day2Question2 {
    String fileLocation = "//Users//jimmcgill//AdventOfCode2022//Day2//input.txt"
    def values = ["Rock":1, "Paper":2, "Scissors":3]

    def player2WinConversions = ["Rock":"Paper", "Paper":"Scissors", "Scissors":"Rock"]

    def player2LoseConversions = ["Rock":"Scissors", "Scissors":"Paper", "Paper":"Rock"]

    def choiceCoversion = ["A":"Rock", "B":"Paper", "C":"Scissors"]

    static void main(String[] args) {
        Day2Question2 q2 = new Day2Question2()
        q2.run()
    }

    public void run() {
        def totalPoints = calculateTotalPoints()
        println totalPoints
    }

    def calculateTotalPoints() {
        File file = new File(fileLocation)
        int totalPoints = 0
        file.eachLine{line ->
            def entries = line.split()
            def player1 = choiceCoversion.get(entries[0])
            def player2 = player2Choice(player1, entries[1])
            totalPoints += calculateRound(player1, player2)
            println totalPoints + " " + player1 + " " + player2
        }
        return totalPoints
    }

    def player2Choice(player1, player2){

        def selection

        switch(player2){
            case "X":
                selection = player2LoseConversions.get(player1)
                break
            case "Y":
                selection = player1
                break
            case "Z":
                selection = player2WinConversions.get(player1)
                break
            default:
                println "Failed to convert for ${player2}"
        }

        return selection
    }

    def calculateRound(player1, player2){

        def pointsForResult = calculateResults(player1, player2)
        def pointsForChoice = values.get(player2)
        return pointsForResult + pointsForChoice
    }

    def calculateResults(player1, player2){
        def result = 0
        if (player1 == player2){ //We have a tie
            return 3
        }

        //Only checking for Player2 wins because initial set is for loss
        //and we have already taken into account ties above
        switch(player1){
            case "Rock":
                if (player2 == "Paper"){
                    result += 6
                }
                break
            case "Paper":
                if (player2 == "Scissors"){
                    result += 6
                }
                break
            case "Scissors":
                if (player2 == "Rock"){
                    result += 6
                }
                break
            default:
                println "Error trying to process ${player1}"
        }
        return result
    }

}

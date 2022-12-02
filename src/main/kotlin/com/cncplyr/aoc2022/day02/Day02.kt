package com.cncplyr.aoc2022.day02

import com.cncplyr.aoc2022.Day

fun main() {
    println("Advent of Code 2022 - Day 02")

    val day2 = Day02()
    day2.part1()
    day2.part2()
}

class Day02 : Day(2) {
    fun part1() {
        println("Part 1")

        var score = 0

        inputFile.forEachLine {
            val yourMove = it[2] - 23 // Shift X -> A

            score += moveScore(yourMove)
            score += gameScore(it[0], yourMove)
        }

        println("Answer: $score")
    }

    fun part2() {
        println("Part 2")

        var score = 0

        inputFile.forEachLine {
            val yourMove = outcomeToMove(it[0], it[2])

            score += moveScore(yourMove)
            score += gameScore(it[0], yourMove)
        }

        println("Answer: $score")
    }

    private fun outcomeToMove(opponentMove: Char, outcome: Char): Char {
        val modifier = when(outcome) {
            'X' -> -1 // Loss
            'Y' -> 0  // Draw
            'Z' -> 1  // Win
            else -> 0
        }

        var yourMove = opponentMove.plus(modifier)
        if (yourMove.code == 64) {
            yourMove = 'C'
        } else if (yourMove.code == 68) {
            yourMove = 'A'
        }

        return yourMove
    }

    /**
     * Rock (A) = 1 point, Paper (B) = 2 points, Scissors (C) = 3 points.
     */
    private fun moveScore(move: Char): Int {
        return when(move) {
            'A' -> 1
            'B' -> 2
            'C' -> 3
            else -> 0
        }
    }

    /**
     * Win = 6 points, Draw = 3 points, Loss = 0 points.
     */
    private fun gameScore(opponentMove: Char, yourMove: Char): Int {
        if (opponentMove == yourMove) {
            // Draw
            return 3
        }

        if (yourMove == opponentMove + 1) {
            // Win
            return 6
        }
        if (yourMove == 'A' && opponentMove == 'C') {
            // Win
            return 6
        }

        // Lose
        return 0
    }
}
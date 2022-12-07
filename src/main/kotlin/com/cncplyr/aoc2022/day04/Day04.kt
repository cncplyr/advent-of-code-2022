package com.cncplyr.aoc2022.day04

import com.cncplyr.aoc2022.Day

fun main() {
    println("Advent of Code 2022 - Day 04")

    val day4 = Day04()
    day4.part1()
    day4.part2()
}

class Day04 : Day(4) {
    fun part1() {
        println("Part 1")

        var total = 0

        inputFile.forEachLine {
            val assignments = toAssignments(it)
            val intersection = assignments.first() intersect assignments.last()

            if (intersection == assignments.first() || intersection == assignments.last()) {
                total++
            }
        }

        println("Answer: $total")
    }

    fun part2() {
        println("Part 2")

        val total = inputFile.readLines()
            .map { toAssignments(it) }
            .map { it.first() intersect it.last() }
            .count { it.isNotEmpty() }

        println("Answer: $total")
    }

    private fun toAssignments(input: String): List<Set<Int>> {
        // The list always has two elements - could return a pair instead?
        return input.split(',')
            .map { assignment ->
                val limits = assignment.split('-').map { i -> i.toInt() }
                (limits.first()..limits.last()).toSet()
            }
    }
}
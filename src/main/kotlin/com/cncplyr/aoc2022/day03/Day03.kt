package com.cncplyr.aoc2022.day03

import com.cncplyr.aoc2022.Day

fun main() {
    println("Advent of Code 2022 - Day 03")

    val day3 = Day03()
    day3.part1()
    day3.part2()
}

class Day03 : Day(3) {
    fun part1() {
        println("Part 1")

        var total = 0

        inputFile.forEachLine {
            val chars = it.toCharArray().asList()
            val firstCompartment = chars.subList(0, chars.size / 2).toSet()
            val secondCompartment = chars.subList(chars.size / 2, chars.size).toSet()

            val duplicate = firstCompartment.intersect(secondCompartment).first()
            val duplicateValue = toValue(duplicate)

            print("$duplicateValue ($duplicate), ")
            total += duplicateValue
        }

        println("\nAnswer: $total")
    }

    fun part2() {
        println("Part 2")

        var total = 0

        inputFile.readLines().chunked(3).forEach {
            val c = it.map { i -> i.toCharArray().toSet() }
                .reduce{acc, next -> acc.intersect(next)}
                .first()

            val value = toValue(c)
            print("$value ($c), ")
            total += value
        }

        println("\nAnswer: $total")
    }

    private fun toValue(input: Char): Int {
        return if (input.isUpperCase()) {
            input.code - 38
        } else {
            input.code - 96
        }
    }
}
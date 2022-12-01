package com.cncplyr.aoc2022.day01

import com.cncplyr.aoc2022.Day
import com.cncplyr.aoc2022.util.getFile

fun main() {
    println("Advent of Code 2022 - Day 01")

    val day1 = Day01()
    day1.part1()
    day1.part2()
}

class Day01 : Day(1) {
    fun part1() {
        println("Part 1")

        val blocks = this.countElfCalories(inputFilename)
        val answer = blocks.max()

        println("Answer: $answer")
    }

    fun part2() {
        println("Part 2")

        val blocks = this.countElfCalories(inputFilename)
        val answer = blocks.sortedDescending().subList(0, 3).sum()

        println("Answer: $answer")
    }

    private fun countElfCalories(fileName: String): MutableList<Int> {
        val blocks: MutableList<Int> = mutableListOf()
        val block: MutableList<Int> = mutableListOf()

        val file = getFile(fileName)
        file.forEachLine {
            if (it.isEmpty()) {
                blocks.add(block.sum())
                block.clear()
            } else {
                block.add(it.toInt())
            }
        }

        return blocks
    }
}
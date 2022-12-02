package com.cncplyr.aoc2022

import com.cncplyr.aoc2022.util.getFile
import java.io.File

open class Day(day: Int) {
    private val sampleFilename: String = "day${day.toString().padStart(2, '0')}/sample.txt"
    private val inputFilename: String = "day${day.toString().padStart(2, '0')}/input.txt"

    val sampleFile: File = getFile(sampleFilename)
    val inputFile: File = getFile(inputFilename)
}
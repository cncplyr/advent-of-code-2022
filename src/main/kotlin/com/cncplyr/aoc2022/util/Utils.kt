package com.cncplyr.aoc2022.util

import com.google.common.io.Resources
import java.io.File

fun getFile(fileName: String): File {
    val absoluteFilePath = Resources.getResource(fileName).path.toString()
    return File(absoluteFilePath)
}
package day1

import java.io.File

private fun getInput() = File("src/input/day1.txt")
        .useLines { it.toList() }
        .map { Integer.parseInt(it) }

object PartOne {
    fun calculateFuel(mass: Int) = mass / 3 - 2
    fun solve(masses: List<Int>) = masses.sumBy { calculateFuel(it) }
}

object PartTwo {
    fun calculateFuel(mass: Int): Int {
        val fuel = PartOne.calculateFuel(mass)
        if (fuel <= 0) return 0
        return fuel + calculateFuel(fuel)
    }

    fun solve(masses: List<Int>) = masses.sumBy{ calculateFuel(it) }
}

fun main() {
    val input = getInput()

    println("Part one: ${PartOne.solve(input)}")
    println("Part two: ${PartTwo.solve(input)}")
}
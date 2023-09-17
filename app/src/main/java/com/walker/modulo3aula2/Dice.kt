package com.walker.modulo3aula2

class Dice(
    private val sides: Int
) {
    fun roll(): Int {
        return (1..sides).random()
    }
}
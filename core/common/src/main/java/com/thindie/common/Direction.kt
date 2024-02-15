package com.thindie.common

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}

fun Direction.getOpposite(): Direction {
    return when (this) {
        Direction.UP -> Direction.DOWN
        Direction.DOWN -> Direction.UP
        Direction.LEFT -> Direction.RIGHT
        Direction.RIGHT -> Direction.LEFT
    }
}
package com.demo.rock.game

class GameEngine {
    enum class Result {
        DRAW, WIN, LOOSE
    }

    fun isWinner(player1: Action, player2: Action): Result {

        if (player1 == Action.ROCK) {
            return checkWithRock(player2)
        } else if (player1 == Action.SCISSOR) {
            return checkWithScissor(player2)
        } else {
            return checkWithPaper(player2)
        }

    }

    fun checkWithPaper(player2: Action): Result {
        var result: Result
        if (player2 == Action.PAPER) {
            result = Result.DRAW
        } else if (player2 == Action.ROCK) {
            result = Result.WIN
        } else {
            result = Result.LOOSE
        }
        return result
    }

    fun checkWithScissor(player2: Action): Result {
        var result: Result
        if (player2 == Action.SCISSOR) {
            result = Result.DRAW
        } else if (player2 == Action.PAPER) {
            result = Result.WIN
        } else {
            result = Result.LOOSE
        }
        return result
    }

    fun checkWithRock(player2: Action): Result {
        var result: Result
        if (player2 == Action.ROCK) {
            result = Result.DRAW
        } else if (player2 == Action.SCISSOR) {
            result = Result.WIN
        } else {
            result = Result.LOOSE
        }
        return result
    }

}
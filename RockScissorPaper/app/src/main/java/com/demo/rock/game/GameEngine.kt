package com.demo.rock.game

class GameEngine constructor(str: String) {
    var map = HashMap<Action,Action>()

    init {
        map.put(Action.SCISSOR, Action.PAPER)
        map.put(Action.PAPER, Action.ROCK)
        map.put(Action.ROCK, Action.SCISSOR)
    }
    enum class Result {
        DRAW, WIN, LOOSE
    }

    var name: String = str
    fun isFirstActionWin(player1: Action, player2: Action): Result {
        val winCon = map.get(player1)
        if(winCon == player2) {
            return Result.WIN
        } else if(map.get(player2) == player1){
            return Result.LOOSE
        } else {
            return Result.DRAW
        }
      }


}
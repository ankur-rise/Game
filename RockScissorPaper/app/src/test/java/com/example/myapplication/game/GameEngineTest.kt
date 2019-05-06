package com.example.myapplication.game

import com.demo.rock.game.Action
import com.demo.rock.game.GameEngine
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameEngineTest {
    private lateinit var gameEngine: GameEngine

    @Before
    fun setup() {
        gameEngine = GameEngine()
    }

    @Test
    fun testISWinner_pass() {
        var result = gameEngine.isWinner(Action.PAPER, Action.ROCK)

        Assert.assertEquals(result , GameEngine.Result.WIN)
    }

    @Test
    fun testISWinner_fail() {
        var result = gameEngine.isWinner(Action.SCISSOR, Action.ROCK)

        Assert.assertNotEquals(result , GameEngine.Result.WIN)
    }

}
package com.example.myapplication.game

import com.demo.rock.game.Action
import com.demo.rock.game.GameEngine
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GameEngineTest {
    private lateinit var gameEngine: GameEngine

    @Before
    fun setup() {
        gameEngine = GameEngine("")
    }

    @Test
    fun testISWinner_Win() {
        var result = gameEngine.isFirstActionWin(Action.PAPER, Action.ROCK)

        Assert.assertEquals(result , GameEngine.Result.WIN)
    }

    @Test
    fun testISWinner_draw() {
        var result = gameEngine.isFirstActionWin(Action.PAPER, Action.PAPER)
        assertEquals(result, GameEngine.Result.DRAW)
    }

    @Test
    fun testISWinner_loose() {
        var result = gameEngine.isFirstActionWin(Action.PAPER, Action.SCISSOR)

        Assert.assertEquals(result , GameEngine.Result.LOOSE)
    }

    @Test
    fun testISWinner_Win_Rock() {
        var result = gameEngine.isFirstActionWin(Action.ROCK, Action.SCISSOR)

        Assert.assertEquals(result , GameEngine.Result.WIN)
    }

    @Test
    fun testISWinner_draw_Rock() {
        var result = gameEngine.isFirstActionWin(Action.ROCK, Action.ROCK)
        assertEquals(result, GameEngine.Result.DRAW)
    }

    @Test
    fun testISWinner_loose_Rock() {
        var result = gameEngine.isFirstActionWin(Action.ROCK, Action.PAPER)

        Assert.assertEquals(result , GameEngine.Result.LOOSE)
    }


    @Test
    fun testISWinner_Win_Scissor() {
        var result = gameEngine.isFirstActionWin(Action.SCISSOR, Action.PAPER)

        Assert.assertEquals(result , GameEngine.Result.WIN)
    }

    @Test
    fun testISWinner_draw_Scissor() {
        var result = gameEngine.isFirstActionWin(Action.SCISSOR, Action.SCISSOR)
        assertEquals(result, GameEngine.Result.DRAW)
    }

    @Test
    fun testISWinner_loose_Scissor() {
        var result = gameEngine.isFirstActionWin(Action.SCISSOR, Action.ROCK)

        Assert.assertEquals(result , GameEngine.Result.LOOSE)
    }

}
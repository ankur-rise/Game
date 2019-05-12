package com.demo.rock.ui.presenters

import android.util.Log
import com.demo.rock.game.Action
import com.demo.rock.game.Bot
import com.demo.rock.game.GameEngine
import com.demo.rock.game.IBot
import com.demo.rock.ui.base.BasePresenter
import com.demo.rock.ui.contracts.GameContract
import com.demo.rock.util.TYPE_COMPUTER_COMPUTER
import javax.inject.Inject

class GamePresenter @Inject constructor(game:GameEngine) : BasePresenter<GameContract.View>() {
    private lateinit var bot1: IBot
    private lateinit var bot2: IBot
    private lateinit var mHumanAction: Action
    private val mGameEngine = game


    override fun start() {
        if (mView!!.typeOfGame().compareTo(TYPE_COMPUTER_COMPUTER) == 0) {
            startComputerPlayer1()
            startComputerPlayer2()
            mView!!.setGameForComputerVsComputer()
        } else {
            startComputerPlayer1()
        }

        Log.i(GamePresenter::class.java.simpleName, mGameEngine.name)

    }

    private fun startComputerPlayer1() {
        bot1 = Bot.getInstance()
    }

    private fun startComputerPlayer2() {
        bot2 = Bot.getInstance()
    }

    fun getComputerMove() {
        mView?.showProgress()
        mView?.setProgressMessage("Bot in progress...")
        bot1.getAction(object : IBot.Callback {
            override fun onAction(botAction: Action) {
                if (mView!!.typeOfGame().compareTo(TYPE_COMPUTER_COMPUTER) == 0) {
                    mView?.hideProgress()
                    getSecondComputerMove(botAction)
                } else {
                    resultHumanComputer(botAction)
                }
            }
        })
    }

    private fun getSecondComputerMove(action1: Action) {
        mView?.showProgress()
        mView?.setProgressMessage("Second bot in progress...")
        bot2.getAction(object : IBot.Callback {
            override fun onAction(botAction: Action) {
                val result = mGameEngine.isWinner(action1, botAction)
                mView?.hideProgress()
                mView?.showResult(result, action1, botAction)
            }
        })
    }

    private fun resultHumanComputer(botAction: Action) {
        val result = mGameEngine.isWinner(mHumanAction, botAction)
        mView?.hideProgress()
        mView?.showHumanMove()
        mView?.showResult(result, botAction, mHumanAction)
    }

    fun humanMove(action: Action) {
        mHumanAction = action
        mView?.hideHumanMove()
    }

    fun releaseHandler() {
        bot1?.clear()
        if(::bot2.isInitialized)
        bot2.clear()
    }
}
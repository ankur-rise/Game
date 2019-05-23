package com.demo.rock.game

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper

/** This class instance will work as separate computer player */
class Bot(list:List<Action>, boundry:Int) : IBot {
    val mList = list
    val boundry = boundry
    override fun clear() {
        mHandlerThread.quitSafely()
    }

    companion object {
        fun getInstance(): IBot {
            val list = ArrayList<Action>()
            list.add(Action.ROCK)
            list.add(Action.SCISSOR)
            list.add(Action.PAPER)
            return Bot(list, 2)
        }
    }

    val mHandlerThread = HandlerThread("Bot")
    val mWorkerHandler: Handler
    val mMainHandler = Handler(Looper.getMainLooper())

    init {
        mHandlerThread.start()
        mWorkerHandler = Handler(mHandlerThread.looper)
    }


    override fun getAction(callback: IBot.Callback) {
        mWorkerHandler.postDelayed({
            val action = mList.get(getRandomIndex(boundry))
            mMainHandler.post { callback.onAction(action) }
        }, 3000)

    }

    fun getRandomIndex(booundry:Int): Int {
        return (Math.random() * booundry).toInt()
    }

}
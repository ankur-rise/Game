package com.demo.rock.game

interface IBot {

    fun getAction(callback: Callback)
    fun clear()

    interface Callback {
        fun onAction(action: Action)
    }

}
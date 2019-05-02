package com.demo.rock.game

interface IBot {

    fun getAction(callback: Callback)

    interface Callback {
        fun onAction(action: Action)
    }

}
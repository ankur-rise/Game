package com.demo.rock.ui.contracts

import com.demo.rock.game.Action
import com.demo.rock.ui.base.IBaseView

interface ResultContract {

    interface View :IBaseView {
        fun getGameType():String
        fun getResult():String
        fun setMessage(name: String, mGameType: String)
        fun setImage(action1: Action, action2: Action)
        fun getPlayer1Move():Action
        fun getPlayer2Move():Action
    }
}
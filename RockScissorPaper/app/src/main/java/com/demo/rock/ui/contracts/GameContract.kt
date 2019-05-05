package com.demo.rock.ui.contracts

import com.demo.rock.game.Action
import com.demo.rock.game.GameEngine
import com.demo.rock.ui.base.IBaseView

interface GameContract {

    interface View:IBaseView {
        fun typeOfGame():String
        fun setGameForComputerVsComputer()
        fun showResult(result: GameEngine.Result, action1: Action, action2: Action)
        fun showHumanMove()
        fun hideHumanMove()
        fun setProgressMessage(msg:String)
    }


}
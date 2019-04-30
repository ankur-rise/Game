package com.demo.rock.ui.contracts

import com.demo.rock.ui.base.IBaseView

interface GameContract {

    interface View:IBaseView {
        fun typeOfGame():String
        fun setGameForComputerVsComputer()
    }


}
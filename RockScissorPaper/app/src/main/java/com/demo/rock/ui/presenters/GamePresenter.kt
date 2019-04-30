package com.demo.rock.ui.presenters

import com.demo.rock.ui.base.BasePresenter
import com.demo.rock.ui.contracts.GameContract
import com.demo.rock.util.TYPE_COMPUTER_COMPUTER
import javax.inject.Inject

class GamePresenter @Inject constructor(): BasePresenter<GameContract.View>() {

    override fun start() {
        if(mView!!.typeOfGame().compareTo(TYPE_COMPUTER_COMPUTER)==0) {
            mView!!.setGameForComputerVsComputer()
        }
    }
}
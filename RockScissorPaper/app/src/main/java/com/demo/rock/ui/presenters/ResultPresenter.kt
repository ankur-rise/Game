package com.demo.rock.ui.presenters

import com.demo.rock.ui.base.BasePresenter
import com.demo.rock.ui.contracts.ResultContract
import javax.inject.Inject

class ResultPresenter @Inject constructor() : BasePresenter<ResultContract.View>() {


    override fun start() {
        mView!!.setMessage(mView!!.getResult(), mView!!.getGameType())
        mView!!.setImage(mView!!.getPlayer1Move(), mView!!.getPlayer2Move())
    }
}
package com.demo.rock.ui.presenters

import com.demo.rock.ui.base.BasePresenter
import com.demo.rock.ui.contracts.MainContract
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainContract.View>() {

    override fun start() {
        // nothing to init for this presenter
    }

    fun handleClick(type: String) {
        mView?.openGameActivity(type)
    }
}
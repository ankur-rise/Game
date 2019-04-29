package com.demo.rock.ui.base

abstract class BasePresenter<V : IBaseView> {
    var mView:V? = null

    fun bindView(view:V) {
        mView = view
    }

    fun unbind() {
        mView = null
    }

    abstract fun start()
}
package com.demo.rock.ui.contracts

import com.demo.rock.ui.base.IBaseView

interface MainContract {
    interface View:IBaseView{
        fun openGameActivity()
    }
}
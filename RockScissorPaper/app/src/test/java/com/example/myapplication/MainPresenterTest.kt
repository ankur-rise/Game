package com.example.myapplication

import com.demo.rock.ui.contracts.MainContract
import com.demo.rock.ui.presenters.MainPresenter
import com.demo.rock.util.TYPE_PLAYER_COMPUTER
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainPresenterTest {
    lateinit var presenter:MainPresenter
    @Mock
    lateinit var view:MainContract.View

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter  = MainPresenter()
        presenter.bindView(view)
    }

    @Test
    fun testHandleClick(){
        presenter.handleClick(TYPE_PLAYER_COMPUTER)
        Mockito.verify(view).openGameActivity(TYPE_PLAYER_COMPUTER)
    }

}
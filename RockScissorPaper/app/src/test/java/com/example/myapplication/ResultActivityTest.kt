package com.example.myapplication

import com.demo.rock.game.GameEngine
import com.demo.rock.ui.contracts.ResultContract
import com.demo.rock.ui.presenters.ResultPresenter
import com.demo.rock.util.TYPE_COMPUTER_COMPUTER
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class ResultActivityTest {
    private lateinit var presenter:ResultPresenter
    @Mock
    lateinit var view:ResultContract.View
    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter = ResultPresenter()
        presenter.bindView(view)
    }


    @Test
    fun testStart(){
        `when`(view.getResult()).thenReturn(GameEngine.Result.WIN.name)
        `when`(view.getGameType()).thenReturn(TYPE_COMPUTER_COMPUTER)
        presenter.start()

        verify(view).setMessage(GameEngine.Result.WIN.name, TYPE_COMPUTER_COMPUTER)

    }

}
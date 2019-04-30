package com.demo.rock.ui.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import com.demo.rock.R
import com.demo.rock.di.injector.Injector
import com.demo.rock.ui.contracts.GameContract
import com.demo.rock.ui.presenters.GamePresenter
import com.demo.rock.util.KEY_GAME_TYPE
import javax.inject.Inject

class GameActivity : AppCompatActivity(), GameContract.View {

    @Inject lateinit var presenter: GamePresenter
    lateinit var mGameType:String
    @BindView(R.id.tv_player_1) lateinit var mTvPlayer1:TextView
    @BindView(R.id.tv_player_2) lateinit var mTvPlayer2:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        supportActionBar?.hide()

        Injector().getActivityComponent().inject(this)
        presenter.bindView(this)
        val bundle = intent.extras
        mGameType = bundle.getString(KEY_GAME_TYPE)
        presenter.start()

    }
    override fun typeOfGame(): String {
        return mGameType
    }

    override fun setGameForComputerVsComputer() {
        mTvPlayer2.text = getString(R.string.computer)

    }
    override fun hideProgress() {
    }

    override fun message(msg: String) {
    }

    override fun showProgress() {
    }
}

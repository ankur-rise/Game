package com.demo.rock.ui.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.demo.rock.R
import com.demo.rock.di.injector.Injector
import com.demo.rock.game.Action
import com.demo.rock.game.GameEngine
import com.demo.rock.ui.contracts.GameContract
import com.demo.rock.ui.presenters.GamePresenter
import com.demo.rock.util.*
import javax.inject.Inject

class GameActivity : AppCompatActivity(), GameContract.View {
    override fun setProgressMessage(msg: String) {
        mTvProgress.text = msg
    }

    @Inject
    lateinit var mPresenter: GamePresenter
    private lateinit var mGameType: String
    @BindView(R.id.tv_human_move)
    lateinit var mTvHumanMove: TextView
    @BindView(R.id.tv_player_1)
    lateinit var mTvPlayer1: TextView
    @BindView(R.id.tv_player_2)
    lateinit var mTvPlayer2: TextView

    @BindView(R.id.ll_progress)
    lateinit var mPbLay: LinearLayout
    @BindView(R.id.tv_progress_msg)
    lateinit var mTvProgress: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        supportActionBar?.hide()
        ButterKnife.bind(this)
        Injector().getActivityComponent().inject(this)
        mPresenter.bindView(this)
        val bundle = intent.extras
        mGameType = bundle.getString(KEY_GAME_TYPE)
        mPresenter.start()

    }

    override fun showHumanMove() {
        mTvHumanMove.visibility = View.VISIBLE
    }

    override fun hideHumanMove() {
        mTvHumanMove.visibility = View.GONE
    }

    override fun showResult(result: GameEngine.Result, action1: Action, action2: Action) {
        val intent = Intent(this, ResultActivity::class.java)
        val bundle = Bundle()
        bundle.putString(KEY_GAME_TYPE, mGameType)
        bundle.putSerializable(KEY_RESULT, result)
        bundle.putSerializable(KEY_PLAYER1_MOVE, action1)
        bundle.putSerializable(KEY_PLAYER2_MOVE, action2)
        intent.putExtras(bundle)
        startActivityForResult(intent, REQ_GAME_RESULT)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_GAME_RESULT) {
            if (resultCode == Activity.RESULT_OK) {
                mPresenter.start()
            }
        }
    }

    override fun typeOfGame(): String {
        return mGameType
    }

    override fun setGameForComputerVsComputer() {
        mTvPlayer1.text = getString(R.string.computer_1)
        mTvPlayer2.text = getString(R.string.computer_2)
        mPresenter.getComputerMove()
    }

    override fun hideProgress() {
        mPbLay.visibility = View.GONE
    }

    override fun showProgress() {
        mPbLay.visibility = View.VISIBLE
    }

    override fun message(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    @OnClick(R.id.iv_paper)
    fun onPaperSelect() {
        mPresenter.humanMove(Action.PAPER)
        mPresenter.getComputerMove()
    }

    @OnClick(R.id.iv_rock)
    fun onRockSelect() {
        mPresenter.humanMove(Action.ROCK)
        mPresenter.getComputerMove()
    }

    @OnClick(R.id.iv_scissor)
    fun onScissorSelect() {
        mPresenter.humanMove(Action.SCISSOR)
        mTvHumanMove.visibility = View.GONE
        mPresenter.getComputerMove()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.releaseHandler()
    }

}

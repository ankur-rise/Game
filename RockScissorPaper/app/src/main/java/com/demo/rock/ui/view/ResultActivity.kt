package com.demo.rock.ui.view

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.demo.rock.R
import com.demo.rock.di.injector.Injector
import com.demo.rock.game.Action
import com.demo.rock.game.GameEngine
import com.demo.rock.ui.contracts.ResultContract
import com.demo.rock.ui.presenters.ResultPresenter
import com.demo.rock.util.*
import javax.inject.Inject

class ResultActivity : AppCompatActivity(), ResultContract.View {

    @BindView(R.id.tv_result)
    lateinit var mTv: TextView

    @BindView(R.id.iv_move_1)
    lateinit var mIv1: ImageView

    @BindView(R.id.iv_move_2)
    lateinit var mIv2: ImageView

    lateinit var mGameType: String
    lateinit var result: GameEngine.Result
    lateinit var move1: Action
    lateinit var move2: Action

    @Inject
    lateinit var presenter: ResultPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        // butterknife init
        ButterKnife.bind(this)
        // dagger init
        val injector = Injector()
        injector.getActivityComponent().inject(this)


        val bundle = intent.extras
        result = bundle!!.getSerializable(KEY_RESULT) as GameEngine.Result
        mGameType = bundle!!.getString(KEY_GAME_TYPE)

        // player 1 move
        move1 = bundle.getSerializable(KEY_PLAYER1_MOVE) as Action
        // player 2 move
        move2 = bundle.getSerializable(KEY_PLAYER2_MOVE) as Action

        presenter.bindView(this)
        presenter.start()

    }

    override fun setMessage(result: String, mGameType: String) {
        var text: String
        when(mGameType!!.compareTo(TYPE_COMPUTER_COMPUTER) == 0){
            true ->  text = getString(R.string.bot_1)
            false -> text = getString(R.string.you)
        }

        mTv.text = text.plus(getString(R.string.space)).plus(result)
    }

    override fun setImage(action1: Action, action2: Action) {
        when (action1) {
            Action.SCISSOR -> mIv1.setImageResource(R.drawable.scissor)
            Action.ROCK -> mIv1.setImageResource(R.drawable.rock)
            Action.PAPER -> mIv1.setImageResource(R.drawable.paper)
        }

        when (action2) {
            Action.SCISSOR -> mIv2.setImageResource(R.drawable.scissor)
            Action.ROCK -> mIv2.setImageResource(R.drawable.rock)
            Action.PAPER -> mIv2.setImageResource(R.drawable.paper)
        }
    }


    override fun getGameType(): String {
        return mGameType
    }

    override fun getPlayer1Move(): Action {
        return move1
    }

    override fun getPlayer2Move(): Action {
        return move2
    }

    override fun getResult(): String {
        return result.name
    }

    override fun showProgress() {
        // stub method not useful here
    }

    override fun hideProgress() {
        // stub method not useful here
    }

    override fun message(msg: String) {
        // stub method not useful here
    }

    override fun onBackPressed() {
        // Nothing to do let user uses buttons
    }

    @OnClick(R.id.btn_play)
    fun btnPlayAgain() {
        setResult(Activity.RESULT_OK)
        this.finish()
    }

    @OnClick(R.id.btn_change_mode)
    fun btnChangeMode() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }


}

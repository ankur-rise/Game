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
import com.demo.rock.game.Action
import com.demo.rock.game.GameEngine
import com.demo.rock.util.*

class ResultActivity : AppCompatActivity() {
    @BindView(R.id.tv_result)
    lateinit var mTv: TextView

    @BindView(R.id.iv_move_1)
    lateinit var mIv1:ImageView

    @BindView(R.id.iv_move_2)
    lateinit var mIv2:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        ButterKnife.bind(this)
        val bundle = intent.extras
        val result: GameEngine.Result = bundle.getSerializable(KEY_RESULT) as GameEngine.Result
        val mGameType = bundle.getString(KEY_GAME_TYPE)
        setMessage(result.name, mGameType)

        val move1:Action = bundle.getSerializable(KEY_PLAYER1_MOVE) as Action
        setImage(move1, mIv1)

        val move2:Action = bundle.getSerializable(KEY_PLAYER2_MOVE) as Action
        setImage(move2, mIv2)

    }

    private fun setMessage(name: String, mGameType: String?) {
        if(mGameType!!.compareTo(TYPE_COMPUTER_COMPUTER) == 0){
           mTv.text = "Bot 1" + name
        } else {
            mTv.text = "You "+name
        }
    }

    private fun setImage(action: Action, iv: ImageView) {
        when(action){
            Action.SCISSOR -> iv.setImageResource(R.drawable.scissor)
            Action.ROCK -> iv.setImageResource(R.drawable.rock)
            Action.PAPER -> iv.setImageResource(R.drawable.paper)
        }
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

    override fun onBackPressed() {
        // Nothing to do let user uses buttons
    }
}

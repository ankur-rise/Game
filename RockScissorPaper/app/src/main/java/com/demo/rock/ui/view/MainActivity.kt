package com.demo.rock.ui.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.OnClick
import com.demo.rock.R
import com.demo.rock.di.injector.Injector
import com.demo.rock.ui.contracts.MainContract
import com.demo.rock.ui.presenters.MainPresenter
import com.demo.rock.util.KEY_GAME_TYPE
import com.demo.rock.util.TYPE_COMPUTER_COMPUTER
import com.demo.rock.util.TYPE_PLAYER_COMPUTER
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        val actvityCompo = Injector().getActivityComponent()
        supportActionBar?.hide()
        actvityCompo.inject(this)
        presenter.bindView(this)
        presenter.start()
    }

    override fun openGameActivity(type: String) {
        val intent = Intent(this, GameActivity::class.java)
        val bundle = Bundle()
        bundle.putString(KEY_GAME_TYPE, type)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun message(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    @OnClick(R.id.tv_pl_co)
    fun onPlayerComputer() {
        presenter.handleClick(TYPE_PLAYER_COMPUTER)

    }

    @OnClick(R.id.tv_com_com)
    fun onComputerComputer() {
        presenter.handleClick(TYPE_COMPUTER_COMPUTER)

    }
}

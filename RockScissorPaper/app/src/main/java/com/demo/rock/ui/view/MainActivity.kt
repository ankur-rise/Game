package com.demo.rock.ui.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.demo.rock.R
import com.demo.rock.di.injector.Injector
import com.demo.rock.ui.contracts.MainContract
import com.demo.rock.ui.presenters.MainPresenter
import com.demo.rock.util.KEY_GAME_TYPE
import com.demo.rock.util.TYPE_COMPUTER_COMPUTER
import com.demo.rock.util.TYPE_PLAYER_COMPUTER
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject lateinit var presenter:MainPresenter
    override fun openGameActivity() {

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun message(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actvityCompo = Injector().getActivityComponent()
        supportActionBar?.hide()
        actvityCompo.inject(this)
        presenter.bindView(this)
        presenter.start()
    }

    fun onPlayerComputer(view: View) {
        var intent = Intent(this, GameActivity::class.java)
        val bundle = Bundle()
        bundle.putString(KEY_GAME_TYPE, TYPE_PLAYER_COMPUTER)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    fun onComputerComputer(view: View) {
        var intent = Intent(this, GameActivity::class.java)
        val bundle = Bundle()
        bundle.putString(KEY_GAME_TYPE, TYPE_COMPUTER_COMPUTER)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}

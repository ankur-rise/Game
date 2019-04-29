package com.demo.rock.ui.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.demo.rock.R
import com.demo.rock.di.injector.Injector
import com.demo.rock.ui.contracts.MainContract
import com.demo.rock.ui.presenters.MainPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject lateinit var presenter:MainPresenter
    override fun openGameActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun message(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var actvityCompo = Injector().getActivityComponent()
        actvityCompo.inject(this)
        presenter.bindView(this)
        presenter.start()
    }

    fun onPlayerComputer(view: View) {

    }

    fun onComputerComputer(view: View){

    }
}

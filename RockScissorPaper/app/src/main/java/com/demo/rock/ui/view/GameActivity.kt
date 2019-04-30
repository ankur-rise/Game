package com.demo.rock.ui.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.demo.rock.R

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        supportActionBar?.hide()
    }
}

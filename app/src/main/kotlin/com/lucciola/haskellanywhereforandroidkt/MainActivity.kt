package com.lucciola.haskellanywhereforandroidkt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.support.v7.widget.Toolbar

import com.lucciola.haskellanywhereforandroidkt.controller.Controller
import com.lucciola.haskellanywhereforandroidkt.controller.SendButtonController
import com.lucciola.haskellanywhereforandroidkt.controller.SymbolButtonController
import com.lucciola.haskellanywhereforandroidkt.controller.UpDownButtonController

class MainActivity : AppCompatActivity() {

    private var view: View? = null
    private var sendButtonController: Controller? = null
    private var upDownButtonController: Controller? = null
    private var symbolButtonController: Controller? = null
    private var manager: ProgramManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myToolBar = findViewById(R.id.my_toolbar) as Toolbar
        setSupportActionBar(myToolBar)

        view = View(this)
        manager = ProgramManager()
        sendButtonController = SendButtonController(view!!, manager!!)
        upDownButtonController = UpDownButtonController(view!!, manager!!)
        symbolButtonController = SymbolButtonController(view!!, manager!!)

        this.view!!.sendButton!!.setOnClickListener(sendButtonController)
        this.view!!.upButton!!.setOnClickListener(upDownButtonController)
        this.view!!.downButton!!.setOnClickListener(upDownButtonController)
    }

    fun onSymbolButtonClick(v: android.view.View) {
        symbolButtonController!!.onClick(v)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.action_bar_menu, menu)
        return true
    }
}

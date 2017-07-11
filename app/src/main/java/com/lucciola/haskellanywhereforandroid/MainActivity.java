package com.lucciola.haskellanywhereforandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.support.v7.widget.Toolbar;

import com.lucciola.haskellanywhereforandroid.controller.Controller;
import com.lucciola.haskellanywhereforandroid.controller.SendButtonController;
import com.lucciola.haskellanywhereforandroid.controller.SymbolButtonController;
import com.lucciola.haskellanywhereforandroid.controller.UpDownButtonController;

public class MainActivity extends AppCompatActivity {

    private View view;
    private Controller sendButtonController;
    private Controller upDownButtonController;
    private Controller symbolButtonController;
    private ProgramManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolBar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolBar);

        view = new View(this);
        manager = new ProgramManager();
        sendButtonController = new SendButtonController(view, manager);
        upDownButtonController = new UpDownButtonController(view, manager);
        symbolButtonController = new SymbolButtonController(view, manager);

        this.view.getSendButton().setOnClickListener(sendButtonController);
        this.view.getUpButton().setOnClickListener(upDownButtonController);
        this.view.getDownButton().setOnClickListener(upDownButtonController);
    }

    public void onSymbolButtonClick(android.view.View v) {
        symbolButtonController.onClick(v);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }
}

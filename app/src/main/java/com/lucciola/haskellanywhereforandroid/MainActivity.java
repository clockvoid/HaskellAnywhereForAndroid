package com.lucciola.haskellanywhereforandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.AppCompatImageButton;
import android.widget.TextView;
import android.widget.EditText;

import com.lucciola.haskellanywhereforandroid.controller.Controller;
import com.lucciola.haskellanywhereforandroid.controller.SendButtonController;
import com.lucciola.haskellanywhereforandroid.controller.SymbolButtonController;
import com.lucciola.haskellanywhereforandroid.controller.UpDownButtonController;

public class MainActivity extends AppCompatActivity {

    private Model model;
    private Controller sendButtonController;
    private Controller upDownButtonController;
    private Controller symbolButtonController;
    private ProgramManager manager;
    private EditText input;
    private TextView monitor;
    private AppCompatImageButton sendButton;
    private AppCompatImageButton upButton;
    private AppCompatImageButton downButton;

    private void createUIPartsInstans() {
        input = (EditText)findViewById(R.id.input);
        monitor = (TextView)findViewById(R.id.monitor);
        sendButton = (AppCompatImageButton)findViewById(R.id.send);
        upButton = (AppCompatImageButton)findViewById(R.id.up);
        downButton = (AppCompatImageButton)findViewById(R.id.down);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolBar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolBar);

        createUIPartsInstans();

        model = new Model(input, monitor);
        manager = new ProgramManager();
        sendButtonController = new SendButtonController(model, this, manager);
        upDownButtonController = new UpDownButtonController(model, this, manager);
        symbolButtonController = new SymbolButtonController(model, this, manager);

        sendButton.setOnClickListener(sendButtonController);
        upButton.setOnClickListener(upDownButtonController);
        downButton.setOnClickListener(upDownButtonController);
    }

    public void onSymbolButtonClick(View v) {
        symbolButtonController.onClick(v);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }
}

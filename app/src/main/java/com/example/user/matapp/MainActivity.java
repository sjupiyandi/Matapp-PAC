package com.example.user.matapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button _button;
    private TextView _textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _button = (Button) findViewById(R.id.button);
        _textView = (TextView) findViewById(R.id.textView);
        _button.setOnClickListener(this);
        _textView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        } else if (v.getId() == R.id.textView) {
            Intent intent = new Intent(MainActivity.this, DaftarActivity.class);
            startActivity(intent);
        }
    }
}

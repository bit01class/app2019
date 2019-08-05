package com.bit.myapp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        TextView tv= findViewById(R.id.result);
        Intent intent=this.getIntent();
        String msg=intent.getStringExtra("param1");
        tv.setText(msg);
    }
}

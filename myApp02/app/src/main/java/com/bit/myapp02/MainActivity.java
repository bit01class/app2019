package com.bit.myapp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void next(View view){
        Intent intent=new Intent(this,TwoActivity.class);
//        intent.setClass(this,TwoActivity.class);
//        intent.setClassName(this,"com.bit.myapp02.TwoActivity");
        intent.putExtra("param1","abcdefg");
        startActivity(intent);

    }
}

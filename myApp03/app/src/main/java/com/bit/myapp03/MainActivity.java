package com.bit.myapp03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private EditText ed01;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed01=findViewById(R.id.ed01);
        final ProgressBar pbar1=findViewById(R.id.pbar1);
        webView=findViewById(R.id.webview);


//        webView.loadUrl("file:///android_asset/www/index.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                pbar1.setProgress(newProgress);
                if(newProgress==100){
                    pbar1.setVisibility(View.GONE);
                }else{
                    pbar1.setVisibility(View.VISIBLE);
                }
            }
        });


        webView.loadUrl("https://getbootstrap.com/");



    }

    public void goUrl(View view) {
        String url=ed01.getText().toString();
        if(!url.startsWith("http://")){
            url="http://"+url;
        }
        webView.loadUrl(url);
    }
}























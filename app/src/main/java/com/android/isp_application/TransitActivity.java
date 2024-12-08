package com.android.isp_application;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.webkit.WebSettings;



import androidx.appcompat.app.AppCompatActivity;


public class TransitActivity extends AppCompatActivity {
        WebView webView;
        ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transit);

        webView = findViewById(R.id.web_view);
        progressBar = findViewById(R.id.loading_progressbar);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);

        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
            }
        });

        loadMyUrl("https://www.metrobus.com");
    }
    void loadMyUrl(String url){
        boolean matchUrl = Patterns.WEB_URL.matcher(url).matches();
        if (matchUrl){
            webView.loadUrl(url);
        }else{
            webView.loadUrl("google.com/search?q="+url);
        }
    }
    class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.INVISIBLE);
        }


    }

}
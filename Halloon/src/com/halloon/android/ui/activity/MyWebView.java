package com.halloon.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.halloon.android.R;
import com.halloon.android.ui.BaseActivity;

public class MyWebView extends BaseActivity {

	private WebView mWebView;
	private String url;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.mywebview);
		Intent intent=getIntent();
		url=intent.getStringExtra("url");
		findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		mWebView = (WebView) findViewById(R.id.webview);
		mWebView.setVerticalScrollBarEnabled(false);
		mWebView.setHorizontalScrollBarEnabled(false);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.loadUrl(url);
	}
	
	
}

package com.harlan.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @author gongzhen
 * @E-mail: oscar.gong@gmail.com
 * @version 创建时间：2014年6月26日 下午1:56:04 程序的简单说明
 */
public class HarlanWebViewClient extends WebViewClient {

	private static final String TAG = HarlanWebViewClient.class.getSimpleName();

	private Activity mParent;

	public HarlanWebViewClient(Activity parent) {
		super();
		this.mParent = parent;
	}

	/**
	 * 点击页面的某条链接进行跳转的话，会启动系统的默认浏览器进行加载，调出了我们本身的应用
	 * 因此，要在shouldOverrideUrlLoading方法中
	 * 
	 * 
	 * True if the host application wants to leave the current WebView and
	 * handle the url itself, otherwise return false.
	 * 
	 * 返回false，说明仍然由WebView来控制
	 * 
	 * 返回true，说明交由其他Activity来控制
	 */
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		/****
		 * 
		 * */
		// 使用当前的WebView加载页面
		// view.loadUrl(url);
		// return true;

		/****
		 * 
		 * 
		 * */
//		String host= Uri.parse(url).getHost();
//		Log.v(TAG, "解析出来的主机名是：" + host);
//		if (host.equalsIgnoreCase("www.sina.com")) {
//			// This is my web site, so do not override; let my WebView load the
//			// page
//			return false;
//		}
//		// Otherwise, the link is not for a page on my site, so launch another
//		// Activity that handles URLs
//		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//		mParent.startActivity(intent);
//		return true;
		
		/****
		 * 
		 * */
		return false;
	}

	/*
	 * 网页加载完毕(仅指主页，不包括图片)
	 */
	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		// TODO Auto-generated method stub
		super.onPageStarted(view, url, favicon);
	}

	/*
	 * 网页加载完毕(仅指主页，不包括图片)
	 */
	@Override
	public void onPageFinished(WebView view, String url) {
		// TODO Auto-generated method stub
		super.onPageFinished(view, url);
	}

	/*
	 * 加载页面资源
	 */
	@Override
	public void onLoadResource(WebView view, String url) {
		// TODO Auto-generated method stub
		super.onLoadResource(view, url);
	}

	/*
	 * 错误提示
	 */
	@Override
	public void onReceivedError(WebView view, int errorCode,
			String description, String failingUrl) {
		// TODO Auto-generated method stub
		super.onReceivedError(view, errorCode, description, failingUrl);
	}
}

package com.harlan.demo.activity;

import android.app.Activity;
import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * @author gongzhen
 * @E-mail: oscar.gong@gmail.com
 * @version 创建时间：2014年6月26日 下午1:32:32
 * 程序的简单说明
 */
/***
 * webChromeClient主要是将javascript中相应的方法翻译成android本地方法
 * 
 * 例如：我们重写了onJsAlert方法，那么当页面中需要弹出alert窗口时，便 会执行我们的代码，按照我们的Toast的形式提示用户。
 */
public class HarlanWebChromeClient extends WebChromeClient {
	
	private static final String TAG = HarlanWebChromeClient.class
			.getSimpleName();

	private Activity mParent;

	public HarlanWebChromeClient(Activity parent) {
		this.mParent = parent;
	}

	// ===================================================================================================================
	//
	// ===================================================================================================================
	/**
	 * 此处覆盖的是javascript中的alert方法。当网页需要弹出alert窗口时，会执行onJsAlert中的方法
	 * 网页自身的alert方法不会被调用。
	 */
	@Override
	public boolean onJsAlert(WebView view, String url, String message,
			JsResult result) {

		Toast.makeText(mParent, message, Toast.LENGTH_LONG).show();
		Log.v(TAG, "弹出了提示框");
		/*
		 * 此处代码非常重要，若没有，android就不能与js继续进行交互了， 且第一次交互后，webview不再展示出来。 result：A
		 * JsResult to confirm that the user hit enter.
		 * 我的理解是，confirm代表着此次交互执行完毕。只有执行完毕了，才可以进行下一次交互。
		 */
		result.confirm();
		return true;

	}

	/**
	 * 此处覆盖的是javascript中的confirm方法。当网页需要弹出confirm窗口时，会执行onJsConfirm中的方法
	 * 网页自身的confirm方法不会被调用。
	 */
	@Override
	public boolean onJsConfirm(WebView view, String url, String message,
			JsResult result) {
		Log.v(TAG, "弹出了确认框");
		result.confirm();
		return true;
	}

	/**
	 * 此处覆盖的是javascript中的confirm方法。当网页需要弹出confirm窗口时，会执行onJsConfirm中的方法
	 * 网页自身的confirm方法不会被调用。
	 */
	@Override
	public boolean onJsPrompt(WebView view, String url, String message,
			String defaultValue, JsPromptResult result) {
		Log.v(TAG, "弹出了输入框");
		result.confirm();
		return true;
	}

	/**
	 * 如果页面被强制关闭,弹窗提示：是否确定离开？ 点击确定 保存数据离开，点击取消，停留在当前页面
	 */
	@Override
	public boolean onJsBeforeUnload(WebView view, String url, String message,
			JsResult result) {
		Log.v(TAG, "弹出了离开确认框");
		result.confirm();
		return true;
	}

	// ===================================================================================================================
	//
	// ===================================================================================================================

	@Override
	public void onProgressChanged(WebView view, int newProgress) {
		// super.onProgressChanged(view, newProgress);
		String progress = "Loading..." + newProgress;
		mParent.setTitle(progress);
		if (newProgress == 100) {
			mParent.setTitle(R.string.app_name);
		}
	}

}

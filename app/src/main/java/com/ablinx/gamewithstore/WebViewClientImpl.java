/* Copyright Ablinx, 2015 */

package com.ablinx.gamewithstore;

import android.app.Activity;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* Adapted from http://tutorials.jenkov.com/android/android-web-apps-using-android-webview.html */
public class WebViewClientImpl extends WebViewClient {

    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        return false;
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        // Ignore SSL certificate errors
        // See http://stackoverflow.com/questions/7416096/android-webview-not-loading-https-url
        handler.proceed();
    }
}
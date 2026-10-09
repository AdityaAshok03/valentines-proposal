package com.adityaashok.valentine;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * The whole app. It shows one full-screen WebView containing the page bundled
 * at assets/index.html -- everything is on the device, so this app needs no
 * internet connection and declares no permissions at all.
 */
public class MainActivity extends Activity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        web = new WebView(this);
        WebSettings s = web.getSettings();

        // The page's buttons and animations are JavaScript, so this is required.
        s.setJavaScriptEnabled(true);

        // Lock everything else down. Assets under file:///android_asset/ stay
        // readable with these off; the rest of the file system does not.
        s.setAllowFileAccess(false);
        s.setAllowContentAccess(false);
        s.setAllowFileAccessFromFileURLs(false);
        s.setAllowUniversalAccessFromFileURLs(false);
        s.setGeolocationEnabled(false);
        s.setSaveFormData(false);

        // Ignore the phone's system font-size setting so the layout can't break.
        s.setTextZoom(100);

        // No pinch-zoom on a single-screen card.
        s.setBuiltInZoomControls(false);
        s.setSupportZoom(false);

        web.setBackgroundColor(0xFFFFE3EC);   // pink, so there's no white flash on launch
        web.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        web.setVerticalScrollBarEnabled(false);

        web.loadUrl("file:///android_asset/index.html");
        setContentView(web);
    }

    @Override
    protected void onDestroy() {
        if (web != null) {
            web.destroy();
            web = null;
        }
        super.onDestroy();
    }
}

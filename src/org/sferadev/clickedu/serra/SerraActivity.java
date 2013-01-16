package org.sferadev.clickedu.serra;

import java.lang.reflect.Field;

import org.sferadev.clickedu.serra.AboutActivity;
import org.sferadev.clickedu.serra.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class SerraActivity extends Activity {

	WebView webview2;
	WebSettings websettings2;

	public void onBackPressed (){

	    if (webview2.isFocused()) {
	            webview2.loadUrl("http://clickedu.coleserra.net/alumnes/index.php");      
	            webview2.setWebViewClient(new InsideWebViewClient2());
	            websettings2 = webview2.getSettings();
	            websettings2.setJavaScriptEnabled(true);
	            websettings2.setBuiltInZoomControls(true);
	    }
	    
	}
	
	@Override
	public boolean onKeyLongPress( int keyCode, KeyEvent event ) {
		if( keyCode == KeyEvent.KEYCODE_BACK ) {
			super.finish();
			return true;
		}
		return super.onKeyLongPress(keyCode, event);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
        webview2 = (WebView) this.findViewById(R.id.webview);
        websettings2 = webview2.getSettings();
        websettings2.setJavaScriptEnabled(true);
        websettings2.setBuiltInZoomControls(true);
        webview2.loadUrl("http://clickedu.coleserra.net/m/m_user.php");
        webview2.setWebViewClient(new InsideWebViewClient2());
        
	}
	
    private class InsideWebViewClient2 extends WebViewClient {
    	public boolean shouldOverrideUrlLoading(WebView view, String url1) {
    		view.loadUrl(url1);
    		return true;
    	}
    	
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.exit:
                finish();
                return true;
                
           case R.id.about:
   			Intent intent = new Intent(this, AboutActivity.class);
   	        this.startActivity(intent);
   	        break;
   			
   		}
        
        return false;
    }
	
}

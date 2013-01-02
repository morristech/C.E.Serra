package org.sferadev.clickedu.serra;

import java.lang.reflect.Field;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.view.Menu;
import android.view.ViewConfiguration;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TabHost host = (TabHost)findViewById(android.R.id.tabhost);
		
		TabSpec spec2 = host.newTabSpec("tab2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("Clickedu");
        host.addTab(spec2);
        WebView webview2 = (WebView) this.findViewById(R.id.webview);
        WebSettings websettings2 = webview2.getSettings();
        websettings2.setJavaScriptEnabled(true);
        websettings2.setBuiltInZoomControls(true);
        webview2.loadUrl("http://clickedu.coleserra.net/m/m_user.php");
        webview2.setWebViewClient(new InsideWebViewClient2());
		
        TabSpec spec1 = host.newTabSpec("tab1");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("SferaDev");
        host.addTab(spec1);
        
        
        
        TabSpec spec3 = host.newTabSpec("tab3");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("About");
        host.addTab(spec3);
        
        
        
	}

 
	private void getOverflowMenu() {
		
		try {
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermamentMenuKey");
			if(menuKeyField != null){
				menuKeyField.setAccessible(true);
				menuKeyField.setBoolean(config, false);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
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

}

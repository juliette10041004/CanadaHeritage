package heritage.canada.com.canadaheritage;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class Saskatchewan_com extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saskatchewan_com);
        WebView webview=(WebView)findViewById(R.id.webViewsas);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://zenit.senecac.on.ca:13024/map/sas/Heo_add.php");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saskatchewan_com, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        switch (item.getItemId()) {
            case R.id.menu_help:
                Intent helpIntent = new Intent(this, help.class);
                startActivity(helpIntent);
                return true;
            case R.id.menu_about:
                Intent aboutIntent = new Intent(this,about.class);
                startActivity(aboutIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

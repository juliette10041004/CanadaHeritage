package heritage.canada.com.canadaheritage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Rockies extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rockies);

                       /* links to the relavent website */
        ImageButton rockies_web = (ImageButton)findViewById(R.id.rockimageButton10);

        rockies_web.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rockies_browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.canadianrockies.com"));
                startActivity(rockies_browserIntent);
            }
        });

        /*map section*/
        ImageButton rockies_map=(ImageButton)findViewById(R.id.rockimageButton9);
        final Intent rockies_map_Intent= new Intent(this,Rockies_Map.class);

        rockies_map.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(rockies_map_Intent);
            }
        });
          /* commend section*/
        ImageButton rockies_commend = (ImageButton)findViewById(R.id.rockimageButton11);
        // final Intent alberta_command_Intent= new Intent(this,AlbertaCommends.class);

        final Intent rockies_command_Intent= new Intent(this,Rockies_com.class);
        rockies_commend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(rockies_command_Intent);
            }
        });
    }

//http://www.canadianrockies.com/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rockies, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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

package heritage.canada.com.canadaheritage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Northwest extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northwest);

          /* links to the relavent website */
        ImageButton north_web = (ImageButton)findViewById(R.id.northimageButton10);

       north_web.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent north_browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gov.nt.ca/research/tourism"));
                startActivity(north_browserIntent);
            }
        });

        /*map section*/
        ImageButton north_map=(ImageButton)findViewById(R.id.northimageButton9);
        final Intent northwest_map_Intent= new Intent(this,Northwest_Map.class);

        north_map.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(northwest_map_Intent);
            }
        });

           /* commend section*/
        ImageButton north_commend = (ImageButton)findViewById(R.id.northimageButton11);
        // final Intent alberta_command_Intent= new Intent(this,AlbertaCommends.class);

        final Intent north_command_Intent= new Intent(this,Northwest_com.class);
        north_commend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(north_command_Intent);
            }
        });

    }

////http://www.gov.nt.ca/research/tourism/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_northwest, menu);
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

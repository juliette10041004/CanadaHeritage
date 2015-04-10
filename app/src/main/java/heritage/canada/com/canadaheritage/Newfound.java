package heritage.canada.com.canadaheritage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Newfound extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newfound);

        ImageButton newfound_web = (ImageButton)findViewById(R.id.newfimageButton10);

        newfound_web.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newf_browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pc.gc.ca/eng/pn-np/nl/grosmorne/index.aspx"));
                startActivity(newf_browserIntent);
            }
        });

        /*map section*/
        ImageButton newfound_map=(ImageButton)findViewById(R.id.newfimageButton9);
        final Intent newfound_map_Intent= new Intent(this,Newfound_Map.class);

        newfound_map.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(newfound_map_Intent);
            }
        });

         /* commend section*/
        ImageButton newf_commend = (ImageButton)findViewById(R.id.newfimageButton11);
        // final Intent alberta_command_Intent= new Intent(this,AlbertaCommends.class);

        final Intent newf_command_Intent= new Intent(this,Newfound_com.class);
        newf_commend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(newf_command_Intent);
            }
        });

    }


    //http://www.pc.gc.ca/eng/pn-np/nl/grosmorne/index.aspx

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_newfound, menu);
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

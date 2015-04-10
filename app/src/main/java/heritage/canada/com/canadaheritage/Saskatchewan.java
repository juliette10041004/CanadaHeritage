package heritage.canada.com.canadaheritage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Saskatchewan extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saskatchewan);

                          /* links to the relavent website */
        ImageButton sas_web = (ImageButton)findViewById(R.id.sasimageButton10);

        sas_web.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sas_browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tourismsaskatchewan.com"));
                startActivity(sas_browserIntent);
            }
        });


         /*map section*/
        ImageButton alberta_map=(ImageButton)findViewById(R.id.sasimageButton9);
        final Intent sas_map_Intent= new Intent(this,Saskatchewan_Map.class);

        alberta_map.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(sas_map_Intent);
            }
        });

          /* commend section*/
        ImageButton sask_commend = (ImageButton)findViewById(R.id.sasimageButton11);
        // final Intent alberta_command_Intent= new Intent(this,AlbertaCommends.class);

        final Intent sask_command_Intent= new Intent(this,Saskatchewan_com.class);
        sask_commend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(sask_command_Intent);
            }
        });
    }
//http://www.tourismsaskatchewan.com/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saskatchewan, menu);
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

package heritage.canada.com.canadaheritage;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Nova extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova);

                  /* links to the relavent website */
        ImageButton nova_web = (ImageButton)findViewById(R.id.novaimageButton10);

        nova_web.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nova_browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.novascotia.com/explore/top-25/peggys-cove?gclid=CjwKEAjw56moBRD8_4-AgoOqhV4SJADWWVCczpha4DKt-mvfM8xG2Ux9wCYab_MTirtRHUT7Ci8quxoCiMXw_wcB"));
                startActivity(nova_browserIntent);
            }
        });
                /*links to lighthouse at peggys cave*/
        ImageButton nova_map = (ImageButton)findViewById(R.id.novaimageButton9);
        final Intent nova_map_Intent= new Intent(this,NovaScotia_Map.class);
        nova_map.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                startActivity(nova_map_Intent);
            }
        });

           /* commend section*/
        ImageButton nova_commend = (ImageButton)findViewById(R.id.novaimageButton11);
        // final Intent alberta_command_Intent= new Intent(this,AlbertaCommends.class);

        final Intent nova_command_Intent= new Intent(this,NovaScotia_com.class);
        nova_commend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(nova_command_Intent);
            }
        });

    }


//http://www.novascotia.com/explore/top-25/peggys-cove?gclid=CjwKEAjw56moBRD8_4-AgoOqhV4SJADWWVCczpha4DKt-mvfM8xG2Ux9wCYab_MTirtRHUT7Ci8quxoCiMXw_wcB


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nova, menu);
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

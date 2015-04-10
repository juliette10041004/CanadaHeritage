package heritage.canada.com.canadaheritage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Alberta extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alberta);

        /* links to the relavent website */
        ImageButton alberta_web = (ImageButton)findViewById(R.id.albertaimageButton10);


        alberta_web.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alberta_browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://travelalberta.com"));
                startActivity(alberta_browserIntent);
            }
        });
       /* commend section*/
        ImageButton alberta_commend = (ImageButton)findViewById(R.id.albertaimageButton11);
      // final Intent alberta_command_Intent= new Intent(this,AlbertaCommends.class);

        final Intent alberta_command_Intent= new Intent(this,alberta_com.class);
        alberta_commend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(alberta_command_Intent);
            }
        });
        /*map section*/
        ImageButton alberta_map=(ImageButton)findViewById(R.id.albertaimageButton9);
        final Intent alberta_map_Intent= new Intent(this,Alberta_Map.class);

        alberta_map.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(alberta_map_Intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alberta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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

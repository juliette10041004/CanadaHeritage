package heritage.canada.com.canadaheritage;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*image button*/

       ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton1);
        final Intent heritageIntent1= new Intent(this,Heritage_Main.class);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(heritageIntent1);
            }

        });
            /*map section*/
        ImageButton imageButton_map = (ImageButton) findViewById(R.id.imageButton);
        final Intent MapIntent1= new Intent(this,Mainmap.class);

        imageButton_map.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(MapIntent1);
            }

        });

        /*list section*/
        ImageButton imageButton_list = (ImageButton) findViewById(R.id.imageButton2);
        final Intent listIntent1= new Intent(this,List_json.class);

        imageButton_list.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(listIntent1);
            }

        });

        /*search section*/
        ImageButton imageButton_search = (ImageButton) findViewById(R.id.imageButton4);
        final Intent searchIntent1= new Intent(this,List_Search.class);

        imageButton_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(searchIntent1);
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

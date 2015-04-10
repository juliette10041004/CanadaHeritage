package heritage.canada.com.canadaheritage;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class Heritage_Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heritage_main);

        ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButton5);  //nova
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        ImageButton imageButton6 = (ImageButton) findViewById(R.id.imageButton6);  //northwest
        ImageButton imageButton8 = (ImageButton) findViewById(R.id.imageButton8);  //rockies
        ImageButton imageButton9 = (ImageButton) findViewById(R.id.imageButton9);  //newfound
        final Intent nova = new Intent(this,Nova.class);
        final Intent saskatchewan= new Intent(this,Saskatchewan.class);
        final Intent alberta= new Intent(this,Alberta.class);
        final Intent northwest= new Intent(this,Northwest.class);
        final Intent rockies= new Intent(this,Rockies.class);
        final Intent newfound= new Intent(this,Newfound.class);

        imageButton5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(nova);
            }

        });



        imageButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(saskatchewan);
            }

        });

        imageButton7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(alberta);
            }

        });


        imageButton6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(northwest);
            }

        });

        imageButton8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(rockies);
            }

        });
        imageButton9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(newfound);
            }

        });

        //when is click show the explanation about canada
        TextView attract_text = (TextView) findViewById(R.id.textView);

        attract_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_heritage_main, menu);
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

package heritage.canada.com.canadaheritage;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;


public class List_Search extends ActionBarActivity {

    MyDBHandler dbHelper1;
    Location_list contacts;
    List name2;
    Context my1;
    TextView textt;

    private AutoCompleteTextView actv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__search);

        my1 = this;
        dbHelper1 = new MyDBHandler(this);
        name2 = dbHelper1.Get_Name();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,name2);
        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

        actv.setThreshold(3);
        actv.setAdapter(adapter);
        /*map intent*/
        final Intent albertsearch= new Intent(this,Alberta_Map.class);
        final Intent sassearch= new Intent(this,Saskatchewan_Map.class);
        final Intent novasearch= new Intent(this,NovaScotia_Map.class);
        final Intent newfoundsearch= new Intent(this,Newfound_Map.class);
        final Intent northsearch= new Intent(this,Northwest_Map.class);
        final Intent rockiessearch= new Intent(this,Rockies_Map.class);

        /*infor intent*/
        final Intent albertsearch1= new Intent(this,Alberta.class);
        final Intent sassearch1= new Intent(this,Saskatchewan.class);
        final Intent novasearch1= new Intent(this,Nova.class);
        final Intent newfoundsearch1= new Intent(this,Newfound.class);
        final Intent northsearch1= new Intent(this,Northwest.class);
        final Intent rockiessearch1= new Intent(this,Rockies.class);

        textt =(TextView)findViewById(R.id.textViewsearch);
        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selection2 = name2.get(position).toString();
                Button map = (Button)findViewById(R.id.buttonsearch);
                Button info =(Button)findViewById(R.id.buttonsearch2);
                selection2 =selection2.trim();

                if(selection2.equalsIgnoreCase("Alberta")){

                    textt.setText(selection2 +" is able to Click Map or Info buttons ");
                    map.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(albertsearch);
                        }

                    });

                    info.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(albertsearch1);
                        }

                    });


                }
               else if(selection2.equalsIgnoreCase("Saskatchewan")){

                    textt.setText(selection2 +" is able to Click Map or Info buttons ");
                    map.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(sassearch);
                        }

                    });

                    info.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(sassearch1);
                        }

                    });

                }
                else if(selection2.equalsIgnoreCase("Nova Scotia")){
                    textt.setText(selection2 +" is able to Click Map or Info buttons ");
                    map.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(novasearch);
                        }

                    });

                    info.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(novasearch1);
                        }

                    });


                }
                else if(selection2.equalsIgnoreCase("Gros Morne World Heritage Site")){
                    textt.setText(selection2 +" is able to Click Map or Info buttons ");
                    map.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(newfoundsearch);
                        }

                    });

                    info.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(newfoundsearch1);
                        }

                    });

                }
                else if(selection2.equalsIgnoreCase("Northwest Territories")){
                    textt.setText(selection2 +" is able to Click Map or Info buttons ");
                    map.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(northsearch);
                        }

                    });
                    info.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(northsearch1);
                        }

                    });

                }
                else if(selection2.equalsIgnoreCase("Rockies Mountain Parks")){
                    textt.setText(selection2 +" is able to Click Map or Info buttons ");
                    map.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(rockiessearch);
                        }

                    });

                    info.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                            startActivity(rockiessearch1);
                        }

                    });

                }
                else {
                    textt.setText("this location information is limited ");
                }




            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list__search, menu);
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

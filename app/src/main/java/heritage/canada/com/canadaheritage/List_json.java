package heritage.canada.com.canadaheritage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import static heritage.canada.com.canadaheritage.R.layout.*;



public class List_json extends Activity {
    MyDBHandler dbHelper;
    Location_list contacts;

    List name1;
    ListView lv;
    Context my;
    String selection3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_json);

    my = this;
    //dbHelper = new SqlLiteDbHelper(this);
    dbHelper = new MyDBHandler(my);
    dbHelper.openDataBase();
    contacts = new Location_list();
        name1 = dbHelper.Get_Name();
        lv = (ListView) findViewById(R.id.listView2);


        ArrayAdapter adapter = new ArrayAdapter(my,
                android.R.layout.simple_list_item_1, name1);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View view, int position, long id) {


                dbHelper.openDataBase();
                contacts = dbHelper.Get_ContactDetails(position + 1);
                String s = "Name: " + contacts.getName() + "\n" + contacts.getZone();

                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

            }
        });

        registerForContextMenu(lv);

}
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;

        selection3 = name1.get(info.position).toString();
        Toast.makeText(getApplicationContext(), selection3, Toast.LENGTH_SHORT).show();

        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Go to Map");
        menu.add(0, v.getId(), 0, "Go to info");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
       /*map intent*/
        final Intent albertsearch2= new Intent(this,Alberta_Map.class);
        final Intent sassearch2= new Intent(this,Saskatchewan_Map.class);
        final Intent novasearch2= new Intent(this,NovaScotia_Map.class);
        final Intent newfoundsearch2= new Intent(this,Newfound_Map.class);
        final Intent northsearch2= new Intent(this,Northwest_Map.class);
        final Intent rockiessearch2= new Intent(this,Rockies_Map.class);

        if (item.getTitle() == "Go to Map") {

            if(selection3.equalsIgnoreCase("Alberta")) {
                startActivity(albertsearch2);
            }else if(selection3.equalsIgnoreCase("Nova Scotia")){
                startActivity(novasearch2);
            }else if(selection3.equalsIgnoreCase("Saskatchewan")){
                startActivity(sassearch2);
            }else if(selection3.equalsIgnoreCase("Northwest Territories")){
                startActivity(northsearch2);
            }else if(selection3.equalsIgnoreCase("Rockies Mountain Parks")){
                startActivity(rockiessearch2);
            }else if(selection3.equalsIgnoreCase("Gros Morne World Heritage Site")){
                startActivity(newfoundsearch2);
            }
            else{
                Toast.makeText(getApplicationContext(), "this location information is limited", Toast.LENGTH_LONG).show();
            }


        } else if (item.getTitle() == "Go to info") {
            final Intent albertsearch3= new Intent(this,Alberta.class);
            final Intent sassearch3= new Intent(this,Saskatchewan.class);
            final Intent novasearch3= new Intent(this,Nova.class);
            final Intent newfoundsearch3= new Intent(this,Newfound.class);
            final Intent northsearch3= new Intent(this,Northwest.class);
            final Intent rockiessearch3= new Intent(this,Rockies.class);

            if(selection3.equalsIgnoreCase("Alberta")) {
                startActivity(albertsearch3);
            }else if(selection3.equalsIgnoreCase("Nova Scotia")){
                startActivity(novasearch3);
            }else if(selection3.equalsIgnoreCase("Saskatchewan")){
                startActivity(sassearch3);
            }else if(selection3.equalsIgnoreCase("Northwest Territories")){
                startActivity(northsearch3);
            }else if(selection3.equalsIgnoreCase("Rockies Mountain Parks")){
                startActivity(rockiessearch3);
            }else if(selection3.equalsIgnoreCase("Gros Morne World Heritage Site")){
                startActivity(newfoundsearch3);
            }
            else{
                Toast.makeText(getApplicationContext(), "this location information is limited", Toast.LENGTH_LONG).show();
            }
        } else {
            return false;
        }
        return true;
    }

}
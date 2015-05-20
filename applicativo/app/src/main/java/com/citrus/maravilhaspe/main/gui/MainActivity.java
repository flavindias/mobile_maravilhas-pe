package com.citrus.maravilhaspe.main.gui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.citrus.maravilhaspe.R;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }


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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.i("menu", String.valueOf(id));
            return true;
        }

        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_menu_inicio:
                Toast.makeText(this, "Inicio selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.action_menu_natureza:
                Toast.makeText(this, "Natureza selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.action_menu_religiosidade:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.action_menu_historia_e_cultura:
                Toast.makeText(this, "Historia selected", Toast.LENGTH_SHORT)
                        .show();
                break;

            case R.id.action_menu_eventos_e_diversao:
                Toast.makeText(this, "Eventos selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}

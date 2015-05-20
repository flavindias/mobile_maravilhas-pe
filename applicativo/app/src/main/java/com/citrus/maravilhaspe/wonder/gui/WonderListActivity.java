package com.citrus.maravilhaspe.wonder.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.citrus.maravilhaspe.R;
import com.citrus.maravilhaspe.main.gui.MainActivity;

/**
 * Created by Erick on 29/04/2015.
 */
public class WonderListActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, new WonderListFragment())
                    .commit();
        }

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_wonder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
            case R.id.action_menu_inicio:
                this._mainScreen();
                return true;
            case R.id.action_menu_sobre:
                this._sobreScreen();
                return true;
            case R.id.action_menu_natureza:
                this._alterScreen("natureza");
                return true;
            case R.id.action_menu_eventos_e_diversao:
                this._alterScreen("eventos_e_diversao");
                return true;
            case R.id.action_menu_historia_e_cultura:
                this._alterScreen("historia_e_cultura");
                return true;
            case R.id.action_menu_religiosidade:
                this._alterScreen("religiosidade");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void _alterScreen(String type) {
        Intent i = new Intent( this , WonderListActivity.class);
        i.putExtra(WonderListFragment.WONDER_TYPE, type);
        startActivity(i);
    }

    private void _mainScreen() {
        Intent i = new Intent( this , MainActivity.class);
        startActivity(i);
    }

    private void _sobreScreen() {
    }
}

package com.citrus.maravilhaspe.wonder.gui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.citrus.maravilhaspe.R;
import com.citrus.maravilhaspe.main.gui.MainActivity;
import com.citrus.maravilhaspe.wonder.WonderFactory;
import com.citrus.maravilhaspe.wonder.business.IWonderServices;
import com.citrus.maravilhaspe.wonder.domain.Wonder;

public class WonderActivity extends FragmentActivity {
    public static final String WONDER_TYPE = "wonder.type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonder);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
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
                this._dialogSobre();
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

    @Override
    public void onBackPressed() {
        Intent i = new Intent( this , WonderListActivity.class);
        i.putExtra(WonderListFragment.WONDER_TYPE, WONDER_TYPE);
        startActivity(i);
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

    private void _dialogSobre(){
        String text = "Projeto Dispositivos Móveis - Erick Haendel, Flaviano Dias e Thays Melo.";
        new AlertDialog.Builder(this)
                .setTitle("Sobre Nós")
                .setMessage( text )
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_menu_help)
                .show();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        public static final String EXTRA_WONDER_ID = "wonderintent.wonder_id";
        public static int  MUSIC_ID = 0;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_wonder, container, false);

            if (savedInstanceState == null) {
                Bundle extras = getActivity().getIntent().getExtras();
                if(extras == null) {
                    MUSIC_ID = 0;
                } else {
                    MUSIC_ID = (int) getActivity().getIntent().getSerializableExtra(EXTRA_WONDER_ID);
                }
            } else {
                MUSIC_ID = (int) savedInstanceState.getSerializable(EXTRA_WONDER_ID);
            }

            // Creating service handler class instance
            new AsyncTask<Void, Void, Wonder>(){

                @Override
                protected Wonder doInBackground(Void... voids) {
                    IWonderServices wServices = WonderFactory.getInstance().createWonderServices();
                    Wonder wonder = wServices.getWonderById(MUSIC_ID);
                    return wonder;
                }

                @Override
                protected void onPostExecute(Wonder wonder) {
                    getActivity().setTitle(wonder.getName());
                    TextView description = (TextView)getActivity().findViewById(R.id.text_wonder_description);
                    description.setText(wonder.getDescription());
                }

            }.execute();

            return rootView;
        }
    }
}

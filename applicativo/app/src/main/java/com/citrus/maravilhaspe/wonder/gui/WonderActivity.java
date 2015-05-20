package com.citrus.maravilhaspe.wonder.gui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.citrus.maravilhaspe.R;
import com.citrus.maravilhaspe.wonder.WonderFactory;
import com.citrus.maravilhaspe.wonder.business.IWonderServices;
import com.citrus.maravilhaspe.wonder.domain.Wonder;

public class WonderActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonder);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wonder, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
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

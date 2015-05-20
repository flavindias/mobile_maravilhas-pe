package com.citrus.maravilhaspe.wonder.gui;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.citrus.maravilhaspe.R;
import com.citrus.maravilhaspe.wonder.WonderFactory;
import com.citrus.maravilhaspe.wonder.business.IWonderServices;
import com.citrus.maravilhaspe.wonder.domain.Wonder;

import java.util.ArrayList;

/**
 * Created by Erick on 29/04/2015.
 */
public class WonderListFragment extends ListFragment {
    public static final String TYPE = "wonderlistfragment.type";
    private ArrayList<Wonder> mWonders;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Maravilhas");
    }

    @Override
    public void onResume(){
        super.onResume();

        // Creating service handler class instance
        new AsyncTask<Void, Void, ArrayList<Wonder>>(){

            @Override
            protected ArrayList<Wonder> doInBackground(Void... voids) {
                IWonderServices wServices = WonderFactory.getInstance().createWonderServices();
                mWonders = wServices.getAllWonders();
                return mWonders;
            }

            @Override
            protected void onPostExecute(ArrayList<Wonder> wonders) {
                WonderAdapter adapter = new WonderAdapter(wonders);
                setListAdapter(adapter);
            }

        }.execute();

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Wonder wonder = ((WonderAdapter)getListAdapter()).getItem(position);

        Intent i = new Intent(getActivity() , WonderActivity.class);
        i.putExtra(WonderActivity.PlaceholderFragment.EXTRA_WONDER_ID , wonder.getId());

        startActivity(i);
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
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

    private class WonderAdapter extends ArrayAdapter<Wonder>{
        public WonderAdapter(ArrayList<Wonder> wonders){
            super(getActivity() , android.R.layout.simple_list_item_1 , wonders);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if( null == convertView){
                //convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_wonder , null);
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_wonder, null);
            }
            Wonder w = getItem(position);
            TextView title = (TextView)convertView.findViewById(R.id.wonder_list_item_titleTextView);
            title.setText(w.getName());
            return convertView;
        }
    }
}

package com.citrus.maravilhaspe.wonder.gui;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.citrus.maravilhaspe.R;
import com.citrus.maravilhaspe.wonder.WonderFactory;
import com.citrus.maravilhaspe.wonder.business.IWonderServices;
import com.citrus.maravilhaspe.wonder.business.WonderServices;
import com.citrus.maravilhaspe.wonder.domain.WonderLab;
import com.citrus.maravilhaspe.wonder.domain.Wonder;

import java.util.ArrayList;

/**
 * Created by Erick on 29/04/2015.
 */
public class WonderListFragment extends ListFragment {
    private ArrayList<Wonder> mWonders;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getActivity().setTitle("Maravilhas");
        IWonderServices wServices = WonderFactory.getInstance().createWonderServices();
        mWonders = wServices.getAllWonders();
        //mWonders = WonderLab.get(getActivity()).getWonders();
        //ArrayAdapter<Wonder> adapter = new ArrayAdapter<Wonder>(getActivity() , android.R.layout.simple_list_item_1, mWonders);
        Log.i("logs", "raiva12");
        WonderAdapter adapter = new WonderAdapter(mWonders);
        setListAdapter(adapter);
        //Log.i("logs", "raiva");

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
            Log.i("logs", "raiva1");
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if( null == convertView){
                Log.i("logs", "raiva1.2");
                //convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_wonder , null);
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_wonder, null);
            }

            Log.i("logs", "raiva2");

            Wonder w = getItem(position);

            Log.i("logs", "raiva3");
           // TextView title = (TextView)convertView.findViewById(R.id.wonder_list_item_titleTextView);
            //title.setText(w.getName());
            Log.i("logs", "raiva4");
            return convertView;
        }
    }
}

package com.citrus.maravilhaspe.wonder.gui;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
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
    public static final String WONDER_TYPE = "wonderlistfragment.type";
    private static String TYPE = null;
    private ArrayList<Wonder> mWonders;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle extras = getActivity().getIntent().getExtras();
            if (extras == null) {
                TYPE = null;
            } else {
                TYPE = (String) getActivity().getIntent().getSerializableExtra(WONDER_TYPE);
            }
        } else {
            TYPE = (String) savedInstanceState.getSerializable(WONDER_TYPE);
        }

        this.alterTitle(TYPE);
    }

    private void alterTitle(String type) {
        switch (type) {
            case "eventos_e_diversao":
                getActivity().setTitle("Eventos e Diversão");
                break;
            case "historia_e_cultura":
                getActivity().setTitle("História e Cultura");
                break;
            case "natureza":
                getActivity().setTitle("Natureza");
                break;
            case "religiosidade":
                getActivity().setTitle("Religiosidade");
                break;
            default:
                getActivity().setTitle("Maravilhas");
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // Creating service handler class instance
        new AsyncTask<Void, Void, ArrayList<Wonder>>() {

            @Override
            protected ArrayList<Wonder> doInBackground(Void... voids) {
                try {
                    IWonderServices wServices = WonderFactory.getInstance().createWonderServices();
                    mWonders = wServices.getAllWonders(WonderListFragment.TYPE);
                    return mWonders;
                }catch (Exception e){
                    return null;
                }

            }

            @Override
            protected void onPostExecute(ArrayList<Wonder> wonders) {
                try {
                    WonderAdapter adapter = new WonderAdapter(wonders);
                    setListAdapter(adapter);
                }catch (Exception e){

                }
            }

        }.execute();

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Wonder wonder = ((WonderAdapter) getListAdapter()).getItem(position);

        Intent i = new Intent(getActivity(), WonderActivity.class);
        i.putExtra(WonderActivity.PlaceholderFragment.EXTRA_WONDER_ID, wonder.getId());
        i.putExtra(WonderActivity.WONDER_TYPE, TYPE);

        startActivity(i);
    }

    private class WonderAdapter extends ArrayAdapter<Wonder> {
        public WonderAdapter(ArrayList<Wonder> wonders) {
            super(getActivity(), android.R.layout.simple_list_item_1, wonders);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (null == convertView) {
                //convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_wonder , null);
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_wonder, null);
            }
            Wonder w = getItem(position);
            TextView title = (TextView) convertView.findViewById(R.id.wonder_list_item_titleTextView);
            title.setText(w.getName());
            return convertView;
        }
    }
}

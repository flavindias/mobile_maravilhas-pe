package com.citrus.maravilhaspe.main.gui;

/**
 * Created by Erick on 19/05/2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.citrus.maravilhaspe.R;
import com.citrus.maravilhaspe.wonder.gui.WonderListActivity;
import com.citrus.maravilhaspe.wonder.gui.WonderListFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Maravilhas PE");

        // Enabling Up / Back navigation
//        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
  //      getActivity().getActionBar().setIcon(R.drawable.abc_btn_rating_star_on_mtrl_alpha);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        this._events(rootView);
        return rootView;
    }

    private void _events(View view){
        Button btnNatureza = (Button)view.findViewById(R.id.btn_natureza);
        Button btnEventos = (Button)view.findViewById(R.id.btn_eventos);
        Button btnHistoria = (Button)view.findViewById(R.id.btn_historia);
        Button btnReligiosidade = (Button)view.findViewById(R.id.btn_religiosidade);

        btnNatureza.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v){
                Intent i = new Intent(getActivity() , WonderListActivity.class);
                i.putExtra(WonderListFragment.TYPE, "natureza");
                startActivity(i);
            }
        });
    }
}
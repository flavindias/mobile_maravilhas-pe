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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        this._events(rootView);
        return rootView;
    }

    /**
     * Botões da tela inicial
     * @param view
     */
    private void _events(View view){
        Button btnNatureza = (Button)view.findViewById(R.id.btn_natureza);
        btnNatureza.setOnClickListener(onClickListener);
        Button btnEventos = (Button)view.findViewById(R.id.btn_eventos);
        btnEventos.setOnClickListener(onClickListener);
        Button btnHistoria = (Button)view.findViewById(R.id.btn_historia);
        btnHistoria.setOnClickListener(onClickListener);
        Button btnReligiosidade = (Button)view.findViewById(R.id.btn_religiosidade);
        btnReligiosidade.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            Intent i = new Intent(getActivity() , WonderListActivity.class);
            switch(v.getId()){
                case R.id.btn_eventos:
                    i.putExtra(WonderListFragment.WONDER_TYPE, "eventos_e_diversao");
                    break;
                case R.id.btn_historia:
                    i.putExtra(WonderListFragment.WONDER_TYPE, "historia_e_cultura");
                    break;
                case R.id.btn_natureza:
                    i.putExtra(WonderListFragment.WONDER_TYPE, "natureza");
                    break;
                case R.id.btn_religiosidade:
                    i.putExtra(WonderListFragment.WONDER_TYPE, "religiosidade");
                    break;
            }
            startActivity(i);
        }
    };


}
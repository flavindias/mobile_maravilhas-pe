package com.citrus.maravilhaspe.wonder.domain;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Erick on 29/04/2015.
 */
public class WonderLab {
    private ArrayList<Wonder> mWonders;

    private static WonderLab sWonderLab;
    private Context mAppContext;

    private WonderLab(Context appContext){
        mAppContext = appContext;
        mWonders =new ArrayList<Wonder>();

        for(int i = 0; i < 100; i ++){
            Wonder w = new Wonder();
            w.setName("Museu" + i);
            mWonders.add(w);
        }
    }

    public static WonderLab get(Context c){
        if(sWonderLab == null){
            sWonderLab = new WonderLab(c.getApplicationContext());
        }

        return sWonderLab;
    }

    public ArrayList<Wonder> getWonders() { return mWonders; }
}
